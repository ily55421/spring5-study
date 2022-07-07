package com.xpinjection.java8.misused.optional.usage;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author link
 * TODO 可选的集合
 */
public class OptionalForCollections {
    private static final String ADMIN_ROLE = "admin";

    /**
     * 过于冗长
     */
    @Ugly
    class TooVerbose {
        public User findAnyAdmin() {
            Optional<List<User>> users = findUsersByRole(ADMIN_ROLE);
            if (users.isPresent() && !users.get().isEmpty()) {
                return users.get().get(0);
            }
            throw new IllegalStateException("No admins found");
        }

        private Optional<List<User>> findUsersByRole(String role) {
            //real search in DB
            return Optional.empty();
        }
    }

    /**
     * TODO good 干净整洁
     */
    @Good
    class NiceAndClean {
        public User findAnyAdmin() {
            return findUsersByRole(ADMIN_ROLE).stream()
                    .findAny()
                    .orElseThrow(() -> new IllegalStateException("No admins found"));
        }

        private List<User> findUsersByRole(String role) {
            // real search in DB  数据库中的真实搜索
            // 实际查询结果返回
            return Collections.emptyList();
        }
    }
}
