package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * TODO IF语句并不总是坏事
 * @author link
 */
public class IfStatementIsNotAlwaysBadThing {
    /**
     * TODO Ugly 以巧妙的方式组合一些选项
     * 连个容器数转int  reduce归约 求和
     */
    @Ugly
    class CombineSomeOptionalsInCleverWay {
        public Optional<Integer> sum(Optional<Integer> first, Optional<Integer> second) {
            return Stream.of(first, second)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .reduce(Integer::sum);
        }
    }

    /**
     * TODO Ugly 以更聪明的方式玩地图游戏
     */
    @Ugly
    class PlayMapGameInEvenMoreCleverWay {
        public Optional<Integer> sum(Optional<Integer> first, Optional<Integer> second) {
            // b -> second.map(a -> b + a).orElse(b)  映射成相加的值否则返回自身
            return first.map(b -> second.map(a -> b + a).orElse(b))
                    .map(Optional::of)
                    // 返回具有指定当前非空值的Optional  如果a不为空即返回，否则返回 second
                    .orElse(second);
        }
    }

    /**
     * TODO good 老派但完全清晰的代码
     */
    @Good
    class OldSchoolButTotallyClearCode {
        public Optional<Integer> sum(Optional<Integer> first, Optional<Integer> second) {
            // 判空 一个不存在 直接返回null 的容器
            if (!first.isPresent() && !second.isPresent()) {
                return Optional.empty();
            }
            // first.orElse(0) + second.orElse(0) 存在则相加
            return Optional.of(first.orElse(0) + second.orElse(0));
        }
    }
}
