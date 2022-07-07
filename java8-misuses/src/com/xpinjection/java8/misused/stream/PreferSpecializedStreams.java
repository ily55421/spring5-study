package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author link
 * 首选 专业 流
 */
public class PreferSpecializedStreams {
    private final Set<User> users = new HashSet<>();

    /**
     * 一般流使用
     */
    @Ugly
    class GeneralStreamUsage {
        public int getTotalAge() {
            return users.stream()
                    // 映射用户年龄
                    .map(User::getAge)
                    // 使用提供的标识值和关联累积函数对此流的元素执行归约，并返回归约后的值。这相当于
                    // reduce sum求和 Integer 包装类频繁拆箱与装箱
                    // TODO 所谓的归约是将某个计算问题（英语：computational problem）转换为另一个问题的过程。
                    .reduce(0, Integer::sum);
        }
    }

    /**
     * 专业流使用
     */
    @Good
    class SpecializedStreamUsage {
        public int getTotalAge() {
            return users.stream()
                    // 直接转换成intStream流
                    .mapToInt(User::getAge)
                    // 调用intStream中特有的方法   省掉int类型数据的包装与拆箱
                    .sum();
        }
    }

    /**
     * TODO 丑陋的方式
     * TODO 使用平铺映射来统计所有集合中的元素
     */
    @Ugly
    class FlatMapToCountElementsInAllCollections {
        /**
         * 统计所有员工
         * @param departments
         * @return
         */
        public int countEmployees(Map<String, List<User>> departments) {
                        // departments.values().stream() map的所有value 转换成stream
            return (int) departments.values().stream()
                    // 平铺映射所有用户list
                    .flatMap(List::stream)
                    // 统计所有角色数
                    .count();
        }
    }

    /**
     * TODO good 的 使用方式
     * TODO 映射到 Int 以简化计算
     * 分析问题 ： 统计员工的数量（也就是计算员工的总数 只需要数量信息 也就没有必要遍历每个用户）
     */
    @Good
    class MapToIntToSimplifyCalculation {
        public long countEmployees(Map<String, List<User>> departments) {
            return departments.values().stream()
                    // list的长度 映射成int流
                    .mapToInt(List::size)
                    // 求和
                    .sum();
        }
    }
}
