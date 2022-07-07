package com.xpinjection.java8.misused.optional.usage;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.Optional;

/**
 * @author link
 * 内部可选用法
 */
public class InternalOptionalUsage {
    /**
     * TODO ugly 使用空值检查不清楚可选依赖项
     */
    @Ugly
    class UnclearOptionalDependencyWithCheckForNull {
        private Printer printer;

        public void process(User user) {
            //some processing
            if (printer != null) {
                // 非空打印
                printer.print(user);
            }
        }

        public void setPrinter(Printer printer) {
            this.printer = printer;
        }
    }

    /**
     * TODO good 有效的内部可选依赖
     */
    @Good
    class ValidInternalOptionalDependency {
        /**
         * 空容器对象
         */
        private Optional<Printer> printer = Optional.empty();

        public void process(User user) {
            //some processing
            printer.ifPresent(p -> p.print(user));
        }

        public void setPrinter(Printer printer) {
            this.printer = Optional.ofNullable(printer);
        }
    }

    interface Printer {
        void print(User user);
    }
}
