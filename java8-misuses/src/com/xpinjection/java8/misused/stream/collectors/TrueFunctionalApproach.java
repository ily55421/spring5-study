package com.xpinjection.java8.misused.stream.collectors;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * @author link
 * TODO 真正的功能方法（函数）
 */
public class TrueFunctionalApproach {
    /**
     * TODO ugly BeforeJava8 在java8之前
     */
    @Ugly
    class BeforeJava8 {
        /**
         * 查找具有最多角色的用户
         * @param users
         * @return
         */
        public User findUsersWithMostRoles(List<User> users) {
            if (users.isEmpty()) {
                return null;
            }
            // mostPowerful 最具影响力 初始化第一个值
            User mostPowerful = users.iterator().next();
            for (User user : users) {
                // 比较角色数量 多则更改 mostPowerful
                if (user.getRoles().size() > mostPowerful.getRoles().size()) {
                    mostPowerful = user;
                }
            }
            return mostPowerful;
        }
    }

    /**
     * TODO ugly 朴素流方法
     *  Naive 幼稚
     */
    @Ugly
    class NaiveStreamsApproach {
        public User findUsersWithMostRoles(List<User> users) {
            return users.stream()
                    // 调用int比较 然后排序
                    .sorted(comparingInt(u -> u.getRoles().size()))
                    .findFirst()
                    .orElse(null);
        }
    }

    /**
     * TODO 减少(归约 还原)的流
     */
    @Ugly
    class StreamsWithReduction {
        public User findUsersWithMostRoles(List<User> users) {
            return users.stream()
                    // 归约
                    .reduce((u1, u2) ->
                            // 三元表达式判断
                            u1.getRoles().size() > u2.getRoles().size() ? u1 : u2)
                    .orElse(null);
        }
    }

    /**
     * TODO 带比较器的最大值
     */
    @Good
    class MaxWithComparator {
        public User findUsersWithMostRoles(List<User> users) {
            return users.stream()
                    // 比较后求最大值
                    .max(comparingInt(u -> u.getRoles().size()))
                    // 存在则返回get() 否则返回null
                    .orElse(null);
        }
    }
}
