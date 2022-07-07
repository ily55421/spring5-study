package com.xpinjection.java8.good.builder;

/**
 * @author Oleksandr Shkurko
 * builder模式创建实例
 */
public class Sample {

    public static void main(String[] args) {
        User user = User.builder()
                .setId(42)
                .setName("Guest")
                .setAge(23)
                .build();

        System.out.println(user);
        // User[id=42, name='Guest', age=23]
    }
}
