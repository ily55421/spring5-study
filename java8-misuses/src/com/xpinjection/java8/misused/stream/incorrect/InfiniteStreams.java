package com.xpinjection.java8.misused.stream.incorrect;

import com.xpinjection.java8.misused.Annotations.Bad;
import com.xpinjection.java8.misused.Annotations.Good;

import java.util.stream.IntStream;

/**
 * @author link
 * TODO 无限流
 */
public class InfiniteStreams {
    /**
     * infinite 无限流
     */
    @Bad
    public void infinite(){
        // iterate 迭代没有终止条件
        IntStream.iterate(0, i -> i + 1)
                .forEach(System.out::println);
    }

    /**
     * 通过limit限制流的  终止
     */
    @Good
    public void validOne(){
        IntStream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * TODO 仍然无限
     */
    @Bad
    public void stillInfinite(){
        IntStream.iterate(0, i -> ( i + 1 ) % 2)
                // 一直去重
                .distinct()
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * TODO 但是这个 如果很好
     */
    @Good
    public void butThisOneIfFine(){
        IntStream.iterate(0, i -> ( i + 1 ) % 2)
                .limit(10)
                .distinct()
                .forEach(System.out::println);
    }
}
