package com.xpinjection.java8.misused.lambda;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.Optional;

/**
 * @author link
 * TODO Lambda 并不总是最好的选择
 */
public class LambdasAreNotAlwaysTheBestOption {
    /**
     * TODO 不需要的 Lambda 用法
     */
    @Ugly
    class UnneededLambdasUsage {
        public void processAndPrint(String name) {
            Optional.ofNullable(name)
                    // 不需要的判空
                    //.filter(s -> !s.isEmpty())
                    .map(s -> s.toUpperCase())
                    // 流程拼接
                    .map(s -> doProcess(s))
                    .ifPresent(s -> System.out.print(s));
        }

        private String doProcess(String name) {
            return "MR. " + name;
        }
    }

    @Good
    class MethodReferenceUsage {
        public void processAndPrint(String name) {
            Optional.ofNullable(name)
                    // 替换为适当的库方法 ref 引用
                    //.filter(StringUtils::isNotEmpty) // replace with appropriate library method ref
                    .map(String::toUpperCase)
                    .map(this::doProcess)
                    .ifPresent(System.out::print);
        }

        private String doProcess(String name) {
            return "MR. " + name;
        }
    }
}
