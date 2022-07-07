package com.xpinjection.java8.misused.lambda.collections;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.*;

/**
 * @author link
 * 模拟多视图
 */
public class EmulateMultimap {
    private final Map<String, Set<User>> usersByRole = new HashMap<>();

    /**
     * TODO ugly 为键手动插入第一个值的集合
     */
    @Ugly
    class ManuallyInsertSetOnFirstValueForTheKey {
        public void addUser(User user) {
            user.getRoles().forEach(r -> {
                //
                Set<User> usersInRole = usersByRole.get(r.getName());
                // 为空则新增
                if (usersInRole == null) {
                    usersInRole = new HashSet<>();
                    usersByRole.put(r.getName(), usersInRole);
                }
                // 添加用户
                usersInRole.add(user);
            });
        }

        /**
         * 获取角色中的用户组
         * @param role
         * @return
         */
        public Set<User> getUsersInRole(String role) {
            Set<User> users = usersByRole.get(role);
            return users == null ? Collections.emptySet() : users;
        }
    }

    /**
     * TODO good 如果键不存在则计算空集
     */
    @Good
    class ComputeEmptySetIfKeyIsAbsent {
        public void addUser(User user) {
            user.getRoles()
                    .forEach(r ->
                            usersByRole
                                    // usersByRole.get(r.getName()) 如果不存在 则new一个新的set
                    .computeIfAbsent(r.getName(), k -> new HashSet<>())
                                    // 添加用户
                    .add(user)
                    );
        }

        public Set<User> getUsersInRole(String role) {
            // 获取或默认
            return usersByRole.getOrDefault(role, Collections.emptySet());
        }
    }
}
