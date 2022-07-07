package com.xpinjection.java8.misused.stream.incorrect;

import com.xpinjection.java8.misused.Annotations.Bad;

import java.util.stream.IntStream;

/**
 * @author link
 * TODO  不正确的操作示例  忘记终端操作
 * 没有终止操作不会执行
 */
public class ForgotTerminalOperation {
    /**
     * TODO BAD 在现实中什么都不做 不会执行
     *
     */
    @Bad
    public void willDoNothingInReality() {
        IntStream.range(1, 5)
                // 返回由该流的元素组成的流，并在从结果流中消耗元素时对每个元素执行提供的操作。
                .peek(System.out::println)
                .peek(i -> {
                    if (i == 5) {
                        throw new RuntimeException("bang");
                    }
                    // 此方法的存在主要是为了支持调试，您希望在元素流过管道中的某个点时查看它们：
                }).peek(Integer::new);
    }
}
