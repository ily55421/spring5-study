package com.xpinjection.java8.misused.lambda;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.Set;
import java.util.function.Supplier;

/**
 * @author link
 * TODO 惰性计算提高性能
 */
public class LazyCalculationsImprovePerformance {
    /**
     * TODO ugly 使用附加检查进行日志记录以避免计算
     */
    @Ugly
    static class LoggingWithAdditionalCheckToAvoidCalculations {
        private static final Log LOG = null; // init logger with factory

        /**
         * 向用户发送欢迎电子邮件
         * @param users
         */
        public void sendWelcomeEmailToUsers(Set<User> users) {
            // send email
            // 已启用调试
            if (LOG.isDebugEnabled()) {
                // 已为用户发送电子邮件
                LOG.debug("Emails have been sent for users: " + users);
            }
        }

        interface Log {
            void debug(String message);

            boolean isDebugEnabled();
        }
    }

    /**
     * TODO 将 Lambda 传递给延迟计算日志消息的值
     */
    @Good
    static class PassLambdaToLazyCalculateValueForLogMessage {
        private static final Log LOG = null; // init logger with factory

        public void sendWelcomeEmailToUsers(Set<User> users) {
            // send email
            LOG.debug(() -> "Emails have been sent for users: " + users);
        }

        interface Log {
            void debug(String message);

            boolean isDebugEnabled();

            /**
             * 默认方法调用 中进行判断
             * 使用supplier函数接口
             * @param message
             */
            default void debug(Supplier<String> message) {
                if (isDebugEnabled()) {
                    debug(message.get());
                }
            }
        }
    }
}
