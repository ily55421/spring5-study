package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.Optional;

/**
 * @author link
 * TODO 严格检查价值存在
 */
public class StrictCheckOfValuePresence {
    /**
     * TODO 手动检查是否存在抛出异常
     */
    @Ugly
    class ManualCheckForPresenceToThrowException {
        /**
         * 获取用户名称
         * @param userId
         * @return
         */
        public String getUserName(Long userId) {
            Optional<User> user = findById(userId);
            if (user.isPresent()) {
                return user.get().getName();
            }
            // 抛出  非法状态异常
            throw new IllegalStateException("User not found");
        }

        /**
         * 根据用户id删除用户 （存在则删除）
         * @param userId
         */
        public void deleteUser(Long userId) {
            Optional<User> user = findById(userId);
            if (user.isPresent()) {
                delete(user.get());
            }
        }

        /**
         * 删除方法
         * @param user
         */
        private void delete(User user) {
            //delete from DB
        }
    }

    /**
     * TODO OrElse 的抛出用法
     */
    @Good
    class OrElseThrowUsage {
        public String getUserName(Long userId) {
            return findById(userId)
                    // orElseThrow 否则抛出异常
                    .orElseThrow(() -> new IllegalStateException("User not found"))
                    .getName();
        }

        /**
         * 方法引用调用删除
         * @param userId
         */
        public void deleteUser(Long userId) {
            findById(userId).ifPresent(this::delete);
        }

        private void delete(User user) {
            //delete from DB
        }
    }

    /**
     * 根据id查找一个用户
     * @param userId
     * @return
     */
    private Optional<User> findById(Long userId) {
        //search in DB
        return Optional.of(new User(5L, "Mikalai", 33));
    }
}
