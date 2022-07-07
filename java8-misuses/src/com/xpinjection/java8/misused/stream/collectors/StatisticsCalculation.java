package com.xpinjection.java8.misused.stream.collectors;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summarizingInt;

/**
 * @author link
 * TODO 统计计算
 */
public class StatisticsCalculation {
    /**
     * TODO Ugly 多次迭代值 每获取一个数据 一次求值计算
     */
    @Ugly
    class IterateThroughValuesSeveralTimes {
        /**
         * printNameStats 打印姓名统计数据
         *
         * @param users
         */
        public void printNameStats(List<User> users) {
            getNameLengthStream(users)
                    .max()
                    // 存在 打印最大值
                    .ifPresent(max -> System.out.println("MAX: " + max));
            getNameLengthStream(users)
                    .min()
                    // 存在 打印最小值
                    .ifPresent(min -> System.out.println("MIN: " + min));
        }

        /**
         * getNameLengthStream 获取名称长度流
         *
         * @param users
         * @return
         */
        private IntStream getNameLengthStream(List<User> users) {
            return users.stream()
                    .mapToInt(user -> user.getName().length());
        }
    }

    /**
     * TODO good 使用收集器在单次运行中计算统计数据   单次运行中计算统计数据
     */
    @Good
    class CalculateStatisticsInSingleRunWithCollector {
        public void registerUsers(List<User> users) {
            // 内部汇总统计
            IntSummaryStatistics statistics = users.stream()
                    // summarizing Int 总结 int
                    .collect(summarizingInt(user -> user.getName().length()));
            System.out.println("MAX: " + statistics.getMax());
            System.out.println("MIN: " + statistics.getMin());
            System.out.println("AVG: " + statistics.getAverage());
            System.out.println("Count: " + statistics.getCount());
            System.out.println("Sum: " + statistics.getSum());
        }
    }
}
