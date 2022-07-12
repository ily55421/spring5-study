package com.link.spring.scope;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: linK
 * @Date: 2022/7/12 10:31
 * @Description TODO 多个异步任务   并行执行
 * 最后我们注意CompletableFuture的命名规则：
 * <p>
 * xxx()：表示该方法将继续在已有的线程中执行；
 * xxxAsync()：表示将异步在线程池中执行。
 * <p>
 * CompletableFuture可以指定异步处理流程：
 * <p>
 * thenAccept()处理正常结果；
 * exceptional()处理异常结果；
 * thenApplyAsync()用于串行化另一个CompletableFuture；
 * anyOf()和allOf()用于并行化多个CompletableFuture。
 */
public class CompletableFutureTest4 {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureTest4::fetchPrice);
        // CompletableFutureTest4::fetchPrice 触发后会马上执行输出语句

        // 暂停让Future完成:
        Thread.sleep(500);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("thenAccept: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
        // 执行顺序
        // fetched!
        // thenAccept: 123.456
    }

    static double fetchPrice() {
        System.out.println("fetched!");
        return 123.456;
    }
}
