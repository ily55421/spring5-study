package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import static java.util.Optional.ofNullable;

/**
 * @author link
 * TODO  可选
 */
public class OptionalElvis {
    /**
     * TODO ugly  java8之前
     */
    @Ugly
    class BeforeJava8 {
        public String getUserName(User user) {
            return (user != null && user.getName() != null) ? user.getName() : "default";
        }
    }

    /**
     * TODO 使用 Optional IsPresent
     * 多重嵌套
     */
    @Ugly
    class UsingOptionalIsPresent {
        public String getUserName(User user) {
            if (ofNullable(user).isPresent()) {
                if (ofNullable(user.getName()).isPresent()) {
                    return user.getName();
                }
            }
            return "default";
        }
    }

    /**
     * 使用 OrElse
     */
    @Good
    class UsingOrElse {
        String getUserName(User user) {
            // import static java.util.Optional.ofNullable; 静态方法导入
            return ofNullable(user)
                    .map(User::getName)
                    .orElse("default");
        }
    }
}
