package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Role;

import java.util.Optional;

/**
 * @author link
 * TODO 可选工程
 */
public class OptionalOverEngineering {
    /**
     * TODO 工程上的空保护
     */
    @Ugly
    class NullProtectionOverEngineering {
        /**
         * 复制角色对象
         * @param role
         * @return
         */
        public Role copyRole(Role role) {
            Role copy = new Role();
            // 多余调用容器的判空
            Optional.ofNullable(role.getName())
                    .ifPresent(copy::setName);
            copy.setPermissions(role.getPermissions());
            return copy;
        }
    }

    /**
     * TODO 简单的条件复制
     */
    @Good
    class SimpleConditionalCopying {
        public Role copyRole(Role role) {
            Role copy = new Role();

            if (role.getName() != null) {
                copy.setName(role.getName());
            }
            copy.setPermissions(role.getPermissions());
            return copy;
        }
    }
}