package com.xpinjection.java8.misused.lambda;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.Role;
import com.xpinjection.java8.misused.User;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

/**
 *
 * @author link
 * TODO 避免复杂的 Lambda表达式
 */
public class AvoidComplexLambdas {
    private final Set<User> users = new HashSet<>();

    @Ugly
    class UsingComplexLambdaInPlace {
        public Set<User> findEditors() {
            return users.stream()
                    // 复杂的表达式过滤
                    .filter(u -> u.getRoles().stream()
                            .anyMatch(r -> r.getPermissions().contains(Permission.EDIT)))
                    .collect(toSet());
        }
    }

    @Good
    class ComplexityExtractedToMethodReference {
        public Set<User> checkPermission(Permission permission) {
            return users.stream()
                    // 可选
                    //.filter(this::hasEditPermission)
                    .filter(hasPermission(Permission.EDIT))
                    .collect(toSet());
        }

        private Predicate<User> hasPermission(Permission permission) {
            return user -> user.getRoles().stream()
                    .map(Role::getPermissions)
                    .anyMatch(permissions -> permissions.contains(permission));
        }

        /**
         * 是否有编辑权限
         * @param user
         * @return
         */
        private boolean hasEditPermission(User user) {
            // 根据给定参数评估此谓词。
            return hasPermission(Permission.EDIT).test(user);
        }
    }
}
