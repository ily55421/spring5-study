package com.xpinjection.java8.misused.stream.collectors;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author link
 * TODO 收集链
 */
public class CollectorsChain {
    /**
     * TODO ugly 分组依据和转换结果map
     */
    @Ugly
    class GroupByAndTransformResultingMap {
        /**
         * 按用户名获取最大年龄
         * @param users
         * @return
         */
        public Map<String, Integer> getMaxAgeByUserName(List<User> users) {
            return users.stream()
                    // TODO 终止操作 ：根据name进行分组
                    .collect(groupingBy(User::getName))
                    // TODO 遍历每个key
                    .entrySet().stream()
                    // 转成map
                    .collect(toMap(
                            Map.Entry::getKey,
                            // 计算最大年龄
                            e -> e.getValue().stream()
                                    // 映射年龄
                                    .map(User::getAge)
                                    // 归约求值
                                    .reduce(0, Integer::max)
                    ));
        }
    }

    /**
     * TODO Ugly    Group By 使用 Max Collector Unwrapping 可选使用 Finisher
     */
    @Ugly
    class GroupByWithMaxCollectorUnwrappingOptionalWithFinisher {
        public Map<String, Integer> getMaxAgeByUserName(List<User> users) {
            return users.stream().collect(groupingBy(User::getName,
                    // collectingAndThen  and then
                    //  maxBy 求最大值
                    collectingAndThen(maxBy(comparing(User::getAge)),
                            user -> user.get().getAge())));
        }
    }

    /**
     * TODO GOOD 使用合并功能收集到map
     */
    @Good
    class CollectToMapWithMergeFunction {
        public Map<String, Integer> getMaxAgeByUserName(List<User> users) {
            return users.stream()
                    // 返回的Collector不是并发的。
                    // key value 合并规则
                    .collect(toMap(User::getName,
                            User::getAge,
                            Integer::max));
        }
    }

    /**
     * 将 Reduce Collector 应用为下游
     */
    @Good
    class ApplyReduceCollectorAsDownstream {
        public Map<String, Integer> getMaxAgeByUserName(List<User> users) {
            return users.stream()
                    // 分组
                    .collect(groupingBy(User::getName,
                            // TODO  映射  通过在累加之前对每个输入元素应用映射函数，将接受U类型元素的Collector调整为接受T类型元素。
                            mapping(User::getAge,
                            reducing(0, Integer::max))));
        }
    }
}
