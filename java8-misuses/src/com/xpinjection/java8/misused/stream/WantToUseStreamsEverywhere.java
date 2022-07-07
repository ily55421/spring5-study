package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

/**
 * @author link
 * 想在 任何地方使用流
 */
public class WantToUseStreamsEverywhere {
    /**
     * TODO Ugly 使用 Stream 构建 map
     */
    @Ugly
    class UseStreamToBuildMap {
        /**
         * 获取 Jpa 属性
         * @return
         */
        public Map<String, Object> getJpaProperties() {
            return Stream.of(
                    //创建一个表示从指定键到指定值的映射的条目。
                    new AbstractMap.SimpleEntry<>("hibernate.show_sql", "true"),
                    new AbstractMap.SimpleEntry<>("hibernate.format_sql", "true")
            ).collect(collectingAndThen(
                    toMap(Map.Entry::getKey, Map.Entry::getValue),
                    // 收集成 不可更改的map
                    Collections::unmodifiableMap)
            );
        }
    }

    /**
     * TODO good  使用旧的朴实 map
     */
    @Good
    class UseOldPlainMap {
        public Map<String, Object> getJpaProperties() {
            Map<String, Object> properties = new HashMap<>(16);
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
            return Collections.unmodifiableMap(properties);
        }
    }
}
