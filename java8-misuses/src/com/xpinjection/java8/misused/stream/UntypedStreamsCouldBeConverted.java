package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.List;

/**
 * @author link
 * 可以转换无类型的流
 */
public class UntypedStreamsCouldBeConverted {
    /**
     * TODO  Ugly  仅处理特殊类型的值
     */
    @Ugly
    class ProcessOnlyValuesOfSpecialType {
        // 统计double中的非数字个数
        public int countDoubleNaNs(List numbers) {
            int count = 0;
            for (Object e : numbers) {
                if (e instanceof Double) {
                    Double d = (Double) e;
                    //如果此Double值是非数字 (NaN)，则返回true ，否则返回false 。
                    if (d.isNaN()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    /**
     * 可以更改 流的类型
     */
    @Good
    class TypeOfStreamCouldBeChanged {
        public int countDoubleNaNs(List numbers) {
            return (int) numbers.stream()
                    // double实例生成
                    .filter(Double.class::isInstance)
                    // 对象转换
                    .mapToDouble(Double.class::cast)
                    // 判断是否是非数字
                    .filter(Double::isNaN)
                    .count();
        }
    }
}