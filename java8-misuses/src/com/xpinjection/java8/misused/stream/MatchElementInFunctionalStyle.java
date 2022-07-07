package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.User;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author link
 * 功能风格的匹配元素
 */
public class MatchElementInFunctionalStyle {
    private final Set<User> users = new HashSet<>();

    /**
     * 对 For Each 和 External Boolean 使用老式迭代
     * AtomicBoolean 原子布尔值的运用
     */
    @Ugly
    class UseOldSchoolIterationsWithForEachAndExternalBoolean {
        public boolean checkPermission(Permission permission) {
            // 原子布尔值（避免并发情况下数据异常）
            AtomicBoolean found = new AtomicBoolean();
            users.forEach(
                    // 遍历用户组
                    u -> u.getRoles().forEach(
                            // 遍历每个用户所拥有的的角色
                            r -> {
                                // 判断用户是否包含挡圈授权
                                if (r.getPermissions().contains(permission)) {
                                    // 设置为true
                                    found.set(true);
                                }
                            }
                    )
            );
            // 返回授权信息
            return found.get();
        }
    }

    /**
     * 尝试使用带有流过滤器的功能样式
     */
    @Ugly
    class TryToUseFunctionalStyleWithStreamFilter {
        /**
         * 检查授权
         * @param permission
         * @return
         */
        public boolean checkPermission(Permission permission) {
            // 使用filter过滤用户
            return users.stream().filter(
                    u -> u.getRoles().stream()
                            // 过滤用户的角色组
                            .filter(
                                    // 过滤对应角色是否包含授权信息
                                    r -> r.getPermissions().contains(permission))
                            // 统计数量存在对应授权角色 返回当前用户
                            .count() > 0)
                    // 查找第一个对象  是否存在
                    // （存在：true，不存在：false）
                    .findFirst().isPresent();
        }
    }

    /**
     * 尝试使用流匹配
     */
    @Ugly
    class TryToUseStreamMatching {
        public boolean checkPermission(Permission permission) {
            return users.stream()
                    // 任何匹配
                    .anyMatch(u -> u.getRoles().stream()
                            // 角色中任何匹配
                            .anyMatch(r -> r.getPermissions().contains(permission)));
        }
    }

    /**
     * 对子集合使用平面映射
     */
    @Good
    class UseFlatMapForSubCollections {
        public boolean checkPermission(Permission permission) {
            return users.stream()
                    // 使用flatmap 平铺user的角色组转换成流（替代嵌套流）
                    .flatMap(u -> u.getRoles().stream())
                    // 角色任意匹配
                    .anyMatch(r -> r.getPermissions().contains(permission));
        }
    }

    /**
     * 将平面映射与子集合的方法引用一起使用
     */
    @Good
    class UseFlatMapWithMethodReferencesForSubCollections {
        public boolean checkPermission(Permission permission) {
            return users.stream()
                    // 映射角色组为stream
                    .map(User::getRoles)
                    // 平铺映射角色组为stream对象
                    .flatMap(Set::stream)
                    // 任意匹配授权信息
                    .anyMatch(r -> r.getPermissions().contains(permission));
        }
    }
}
