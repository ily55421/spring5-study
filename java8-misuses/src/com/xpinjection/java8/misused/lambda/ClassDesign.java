package com.xpinjection.java8.misused.lambda;

import com.xpinjection.java8.misused.Annotations.Bad;
import com.xpinjection.java8.misused.Annotations.Good;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author link
 * TODO 类设计
 */
public class ClassDesign {
    /**
     * TODO 模棱两可的重载方法
     * 函数式接口的重载 需要区分
     */
    @Bad
    static class AmbiguousOverloadedMethods {
        interface AmbiguousService<T> {
            <R> R process(Function<T, R> fn);

            T process(UnaryOperator<T> fn);
        }

        public void usage(AmbiguousService<String> service) {
            // which method you intended to call??? both are acceptable.
            // 你打算调用哪个方法？？？两者都可以接受。
            service.process(String::toUpperCase);
        }
    }

    /**
     * TODO good 单独的专门方法
     */
    @Good
    static class SeparateSpecializedMethods {
        interface ClearService<T> {
            <R> R convert(Function<T, R> fn);

            T process(UnaryOperator<T> fn);
        }

        public void usage(ClearService<String> service) {
            // now it's clear which method will be called.
            // 现在很清楚将调用哪个方法。
            service.convert(String::toUpperCase);
        }
    }
}
