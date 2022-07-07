package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Role;
import com.xpinjection.java8.misused.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author link
 * 富 领域模型
 */
public class RichDomainModel {
    /**
     * TODO 丑陋的 糟糕的领域模型导致复杂的数据访问代码
     */
    @Ugly
    class PoorDomainModelCausesComplexDataAccessCode {
        private final List<User> users = new ArrayList<>();

        /**
         * 查找角色中的用户
         * @param roleName
         * @return
         */
        public User findUserInRole(String roleName) {
            // 遍历用户组
            for (User user : users) {
                // 遍历每个用户的角色组
                for (Role role : user.getRoles()) {
                    // 比较角色名称
                    if (roleName.equals(role.getName())) {
                        return user;
                    }
                }
            }
            // 查找不到结果 返回null
            return null;
        }
    }

    /**
     * TODO 丑陋的  流版本看起来并没有好多少
     */
    @Ugly
    class StreamVersionLooksNotMuchBetter {
        private final List<User> users = new ArrayList<>();

        public User findUserInRole(String roleName) {
            // 生成stream
            return users.stream().filter(user -> user.getRoles().stream()
                            .map(Role::getName)
                            // 过滤出name相等的user
                            .anyMatch(roleName::equals))
                    // 查找出任何 user Optional对象
                    .findAny()
                    // 否则返回 null
                    .orElse(null);
        }
    }

    /**
     * TODO GOOD 富领域模型可以简化访问代码（在领域模型中封装判断方法）
     */
    @Good
    class RichDomainModelCouldSimplifyAccessCode {
        private final List<BetterUser> users = new ArrayList<>();

        public User findUserInRole(String roleName) {
            return users.stream()
                    // 封装 角色对象的判断方法
                    .filter(user -> user.hasRole(roleName))
                    .findAny()
                    .orElse(null);
        }

        class BetterUser extends User {
            // 全参
            BetterUser(long id, String name, int age) {
                super(id, name, age);
            }

            boolean hasRole(String roleName) {
                // 用户角色组
                return getRoles().stream()
                        .map(Role::getName)
                        // 是否匹配角色名称的对象
                        .anyMatch(roleName::equals);
            }
        }
    }
}
