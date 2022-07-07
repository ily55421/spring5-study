package com.xpinjection.java8.misused;

import java.util.HashSet;
import java.util.Set;

/**
 * @author link
 * TODO 用户普通对象
 */
public class User {
    private Long id;
    private String name;
    private int age;
    /**
     * 初始赋值
     */
    private Set<Role> roles = new HashSet<>();

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
