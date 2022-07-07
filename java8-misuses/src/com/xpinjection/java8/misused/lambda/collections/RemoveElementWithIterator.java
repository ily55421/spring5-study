package com.xpinjection.java8.misused.lambda.collections;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author link
 * TODO 使用迭代器删除元素
 */
public class RemoveElementWithIterator {
    private final Set<User> users = new HashSet<>();

    /**
     * TODO ugly 使用 Iterator Remove 手动删除元素
     */
    @Ugly
    class ManuallyRemoveElementWithIteratorRemove {
        /**
         * 删除有权限的用户
         * @param permission
         */
        public void removeUsersWithPermission(Permission permission) {
            // 获取集合的迭代器
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                // if中复杂的表达式
                if (user.getRoles().stream()
                        .anyMatch(r -> r.getPermissions().contains(permission))) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * TODO good 用Predicate接口判断 删除
     */
    @Good
    class RemoveWithPredicate {
        public void removeUsersWithPermission(Permission permission) {
            // 默认方法有实现迭代器删除逻辑
            // TODO 使用迭代器删除list所有包含过滤条件的角色
            users.removeIf(user -> user.getRoles().stream()
                    .anyMatch(r -> r.getPermissions().contains(permission)));
        }
    }
}