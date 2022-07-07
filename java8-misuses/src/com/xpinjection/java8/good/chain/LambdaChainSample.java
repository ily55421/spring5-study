package com.xpinjection.java8.good.chain;

import java.util.function.Function;

/**
 * @author Alimenkou Mikalai
 * Lambda 链式调用 示例
 */
public class LambdaChainSample {
    public static void main(String[] args) {
        // startWith 开始包含
        int digitsCount = startWith(String::trim)
                .andThen(String::toUpperCase)
                // wrap(counter())包装计算时间   方法引用调用 count
                .andThen(wrap(counter())::count)
                // 应用 （测试）
                .apply(" \n 123 \t");
        System.out.println(digitsCount + " digits found");
        //Counting took 0 ms
        //3 digits found
    }

    private static DigitCounter counter() {
        return new NaiveDigitCounter();
    }

    private static <T, R> Function<T, R> startWith(Function<T, R> function) {
        return function;
    }

    /**
     * 包装 计数结果
     * @param counter
     * @return
     */
    private static DigitCounter wrap(DigitCounter counter) {
        return s -> {
            long startTime = System.currentTimeMillis();
            int count = counter.count(s);
            long endTime = System.currentTimeMillis();
            System.out.println("Counting took " + (endTime - startTime) + " ms");
            // 接口返回int值
            return count;
        };
    }
}
