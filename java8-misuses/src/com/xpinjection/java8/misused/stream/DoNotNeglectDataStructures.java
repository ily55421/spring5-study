package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author link
 * 不要忽视数据结构
 */
public class DoNotNeglectDataStructures {
    /**
     * 不必要地使用嵌套流操作
     */
    @Ugly
    class UnnecessaryUseOfNestedStreamOperations {
        public List<Order> filterOrdersByStatuses(List<Order> orders, Set<Status> appropriateStatuses) {
            return orders.stream()
                    .filter(order ->
                            //过滤流中的任意一个匹配
                            appropriateStatuses.stream().anyMatch(order.getStatus()::equals))
                    .collect(toList());
        }
    }

    /**
     * UseOfDataStructure
     * 数据结构使用
     */
    @Good
    class UseOfDataStructure {
        public List<Order> filterOrdersByStatuses(List<Order> orders, Set<Status> appropriateStatuses) {
            return orders.stream()
                    // 使用数据结构的api
                    .filter(order -> appropriateStatuses.contains(order.getStatus()))
                    .collect(toList());
        }
    }

    /**
     * 状态存储在错误的数据结构中
     *
     */
    @Ugly
    class StateIsStoredInBadDataStructure {
        private final List<Order> orders = new ArrayList<>();

        public void placeOrder(Order order) {
            orders.add(order);
        }

        public List<Order> getOrdersInStatus(Status status) {
            return orders.stream()
                    // 每次需要进行对数据的过滤
                    // 可以考虑对数据预先进行分组
                    // EnumMap
                    .filter(order -> order.getStatus() == status)
                    .collect(toList());
        }
    }

    /**
     * 内部数据结构可以针对访问方法进行优化
     * EnumMap 枚举map存储数据
     */
    @Good
    class InternalDataStructureMayBeOptimizedForAccessMethods {
        //Use multimap instead from external collections like Guava
        private final Map<Status, List<Order>> orders = new EnumMap<>(Status.class);

        public void placeOrder(Order order) {
            // computeIfAbsent 计算如果不存在
            // 1.存在直接返回order.getStatus()
            // 2.不存在则添加到list中
            orders.computeIfAbsent(order.getStatus(), status -> new ArrayList<>()).add(order);
        }

        public List<Order> getOrdersInStatus(Status status) {
            // 获取对应状态的订单集合
            return orders.get(status);
        }
    }

    class Order {
        private Status status = Status.ACTIVE;

        Status getStatus() {
            return status;
        }

        void setStatus(Status status) {
            this.status = status;
        }
    }

    enum Status {
        ACTIVE, SUSPENDED, CLOSED
    }
}
