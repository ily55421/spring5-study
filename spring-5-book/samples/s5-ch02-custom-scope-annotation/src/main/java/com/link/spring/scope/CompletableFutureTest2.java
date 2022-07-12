package com.link.spring.scope;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: linK
 * @Date: 2022/7/12 10:31
 * @Description TODO 多个异步任务   串行执行
 */
public class CompletableFutureTest2 {
    public static void main(String[] args) throws Exception {
        // 第一个任务:  调用的forkJoin线程池
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
//        System.out.println(fetchPrice(queryCode("aaa")));
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
