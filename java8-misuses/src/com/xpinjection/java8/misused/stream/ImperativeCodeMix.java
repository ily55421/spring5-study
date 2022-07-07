package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.Role;
import com.xpinjection.java8.misused.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author link
 *
 * ImperativeCodeMix
 * 命令式代码组合
 */
public class ImperativeCodeMix {
    private static final String ADMIN_ROLE = "admin";

    private final List<User> users = new ArrayList<>();

    /**
     * 流操作和命令式代码的过于冗长的组合
     */
    @Ugly
    class TooVerboseMixOfStreamOperationsAndImperativeCode {
        /**
         * 判断是否为admin 橘色
         * @return
         */
        public boolean hasAdmin() {
            return users.stream()
                    .map(u -> {
                        if (u == null) {
                            throw new NullPointerException();
                        }
                        return u;
                    })
                    .flatMap(u -> u.getRoles().stream())
                    .map(Role::getName)
                    .anyMatch(name -> ADMIN_ROLE.equals(name));
        }
    }

    /**
     * 干净整洁的流运营(运行)链
     */
    @Good
    class NiceAndCleanStreamOperationsChain {
        /**
         * 判断是否为admin 橘色
         * @param permission
         * @return
         */
        public boolean hasAdmin(Permission permission) {
            return users.stream()
                    // Objects::requireNonNull 映射对象判空
                    // 必须为非空
                    .map(Objects::requireNonNull)
                    // 平铺对应的角色组
                    .flatMap(u -> u.getRoles().stream())
                    // 静态方法引用获取角色 名称
                    .map(Role::getName)
                    // 任意一个匹配是否为 admin角色
                    .anyMatch(ADMIN_ROLE::equals);
        }

    }
}
