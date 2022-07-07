package com.xpinjection.java8.misused.stream.collectors;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author link
 * TODO 避免流中的循环
 */
public class AvoidLoopsInStreams {
    private final Set<User> users = new HashSet<>();

    /**
     * TODO 使用外部计数器
     */
    @Ugly
    class UseExternalCounter {
        /**
         * count 每个用户的平均角色数
         * @return
         */
        public double countAverageRolesPerUser() {
            if (users.isEmpty()) {
                return 0;
            }
            AtomicInteger totalCount = new AtomicInteger();
            users.forEach(u -> totalCount.addAndGet(u.getRoles().size()));
            return totalCount.doubleValue() / users.size();
        }
    }

    /**
     * 应用映射到目标类型
     */
    @Good
    class ApplyMappingsToTargetType {
        public double countAverageRolesPerUser() {
            return users.stream()
                    // 转换成double流
                    .mapToDouble(u ->
                            // 获取每个用户的角色数
                            u.getRoles().size())
                    // 求平均
                    .average()
                    // 不存在则返回0
                    .orElse(0);
        }
    }
}
