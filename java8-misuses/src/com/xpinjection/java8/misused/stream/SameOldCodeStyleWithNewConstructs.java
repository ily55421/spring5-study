package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.User;
import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.Collection;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @author link
 * 具有新结构的相同旧代码样式
 */
public class SameOldCodeStyleWithNewConstructs {
    /**
     * TODO 丑陋的  不一样的 旧循环 包含if
     */
    @Ugly
    class NoMoreThanSameOldLoopWithIf {
        public void registerUsers(Collection<User> users) {
            users.stream().forEach(user ->
                    // 判断非空时注册用户
                    // 返回一个描述指定值的Optional ，如果非 null ，否则返回一个空Optional 。
                    // 如果存在值，则使用该值调用指定的使用者，否则不执行任何操作。
                    ofNullable(user).ifPresent(u -> {
                        //register user
                    })
            );
        }
    }

    /**
     * TODO 新stream风格的 方法参考
     */
    @Good
    class NewStreamStyleWithMethodReference {
        public void registerUsers(Collection<User> users) {
            users.stream()
                    // 过滤非空
                    .filter(Objects::nonNull)
                    // 注册用户
                    .forEach(this::registerUser);
        }

        /**
         * 注册用户的方法
         * @param user
         */
        private void registerUser(User user){
            //register user
        }
    }
}
