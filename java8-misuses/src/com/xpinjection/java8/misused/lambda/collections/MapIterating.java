package com.xpinjection.java8.misused.lambda.collections;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author link
 * TODO map 迭代
 */
public class MapIterating {
    /**
     * TODO ugly 使用旧的良好的条目集
     */
    @Ugly
    class UsingOldGoodEntrySet {
        public Map<String, String> getUserNames(Map<String, User> users) {
            Map<String, String> userNames = new HashMap<>();
            // entrySet 条目集遍历
            users.entrySet().forEach(user ->
                    userNames.put(user.getKey(), user.getValue().getName()));
            return userNames;
        }
    }

    /**
     * TODO good 使用map直接遍历
     */
    @Good
    class UsingMapForEach {
        public Map<String, String> getUserNames(Map<String, User> users) {
            Map<String, String> userNames = new HashMap<>();
            // 获取用户名称
            users.forEach((key, value) -> userNames.put(key, value.getName()));
            return userNames;
        }
    }

    /**
     * 使用map 转换
     */
    @Good
    class UsingMapTransform {
        public Map<String, String> getUserNames(Map<String, User> users) {
            return users.entrySet().stream()
                    .collect(toMap(Map.Entry::getKey,
                            // 映射value
                            entry -> entry.getValue().getName()));
        }
    }
}