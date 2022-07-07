package com.xpinjection.java8.misused.stream.collectors;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * @author link
 * TODO 用于分组的外部集合
 */
public class ExternalCollectionForGrouping {
    private final Set<User> users = new HashSet<>();

    /**
     * TODO Ugly 外部状态用于流操作
     */
    @Ugly
    class ExternalStateIsUsedForStreamOperations {
        /**
         * 查找编辑
         * @return
         */
        public Map<String, Set<User>> findEditors() {
            //editors 存储编辑
            Map<String, Set<User>> editors = new HashMap<>(16);
            users.forEach(u ->
                    // 遍历用户 获取所有角色组
                    u.getRoles().stream()
                            // 过滤所有角色中包含edit去授权的角色
                    .filter(r -> r.getPermissions().contains(Permission.EDIT))
                            // 遍历
                    .forEach(r -> {
                        //  使用 Multiset 并避免这种复杂的代码会更好吗
                        //is it better to use Multiset and avoid this complex code
                        // 封装用户和角色  editors.get(r.getName())这里外部set可能一开始为null 而add操作执行在put之后
                        Set<User> usersInRole = editors.get(r.getName());
                        if (usersInRole == null) {
                            usersInRole = new HashSet<>();
                            editors.put(r.getName(), usersInRole);
                        }
                        usersInRole.add(u);
                    })
            );
            return editors;
        }
    }

    /**
     * TODO 当后期需要状态时使用 元组
     */
    @Good
    class TuplesAreUsedWhenStateIsNeededOnLaterPhase {
        public Map<String, Set<User>> findEditors() {
            return users.stream()
                    .flatMap(u -> u.getRoles().stream()
                            //  获得角色组 过滤权限
                        .filter(r -> r.getPermissions().contains(Permission.EDIT))
                            // 映射成 角色 与 用户对象 （元组封装）
                        .map(r -> new Pair<>(r, u))
                    ).collect(groupingBy(p ->
                                    //  KEY为name
                                    p.getKey().getName(),
                            // value 为 用户set
                            mapping(Pair::getValue, toSet())));
        }
    }

    /**
     * any tuple implementation from 3rd party libraries
     * 来自 3rd 方库的任何类型元组实现
     * @param <K> key 的元对象
     * @param <V> value 的元对象
     */
    class Pair<K, V> {
        private final K key;
        private final V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }
}
