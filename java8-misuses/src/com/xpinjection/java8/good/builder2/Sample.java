package com.xpinjection.java8.good.builder2;

/**
 * @author Oleksandr Shkurko
 */
public class Sample {

    public static void main(String[] args) {
        User user = User.builder()
                .setId(1)
                .setName("guest")
                .setAge(18)
                // 返回 UserBuilderRoles
                .addRole("GUEST")
                // 添加角色返回 this
                .addRole("LOGIN").addRole("test")
                .build();

        System.out.println(user);
        // User[id=1, name='guest', age=18, roles=[test, GUEST, LOGIN]]
    }
}
