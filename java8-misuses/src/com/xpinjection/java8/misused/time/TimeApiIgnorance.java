package com.xpinjection.java8.misused.time;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author link
 * 时间api的无知
 * 使用LocalDate 新特性
 */
public class TimeApiIgnorance {
    /**
     * 在 Java 8以前 样式中添加 Day
     */
    @Ugly
    class AddDayInPreJava8Style {
        public Date tomorrow() {
            Calendar now = Calendar.getInstance();
            now.add(Calendar.DAY_OF_MONTH, 1);
            return now.getTime();
        }
    }

    /**
     * 添加一天效率低下
     */
    @Ugly
    class AddDayInefficient {
        public LocalDate tomorrow() {
            // 指定常量类添加
            return LocalDate.now().plus(1, DAYS);
        }
    }

    /**
     * 以 Java 8 风格添加一天
     */
    @Good
    class AddDayInJava8Style {
        public LocalDate tomorrow() {
            // 调用对应包装方法添加
            return LocalDate.now().plusDays(1);
        }
    }
}