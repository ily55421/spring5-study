package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.Role;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author link
 * 创建选项
 */
public class CreationOptions {
    /**
     * 从list中获取stream
     * 1.先转换成list
     * 2.在转换成strean
     * @return
     */
    @Ugly
    public Stream<Permission> getStreamFromList() {
        return Arrays.asList(Permission.ADD, Permission.DELETE).stream();
    }

    /**
     * 1.直接调用stream的转换
     * @return
     */
    @Good
    public Stream<Permission> getStreamFromElements() {
        return Stream.of(Permission.ADD, Permission.DELETE);
    }

    /**
     * 通过映射副本的方式生成stream
     * MappingCopies 复制后映射
     * @param n
     * @return
     */
    @Ugly
    public Stream<Role> generateStreamByMappingCopies(int n) {
        //nCopies copy n份
        return Collections.nCopies(n, "ignored").stream()
                // 每一份映射一个空角色
                .map(s -> new Role());
    }

    /**
     * IntStream 的方式生成stream
     * @param n
     * @return
     */
    @Ugly
    public Stream<Role> generateStreamFromRange(int n) {
        //IntStream.range(0, n) 创建一个0,n范围内的流
        return
                IntStream.range(0, n).mapToObj(i -> new Role());
    }

    /**
     * 使用 Supplier接口生成流 然后做截取
     * 推荐
     * @param n
     * @return
     */
    @Good
    public Stream<Role> generateStreamFromSupplierWithLimit(int n) {
        return Stream.generate(Role::new).limit(n);
    }

    /**
     * 通过array与范围的方式生成流
     * 1.先获取最小值
     * 2.在创建指定范围的流
     * 3.映射成对象
     * @param roles
     * @param max
     * @return
     */
    @Ugly
    public Stream<Role> generateStreamFromArrayWithRange(Role[] roles, int max) {
        int to = Integer.min(roles.length, max);
        return IntStream.range(0, to).mapToObj(i -> roles[i]);
    }

    /**
     * 通过stream流 直接截取
     * @param roles
     * @param max
     * @return
     */
    @Good
    public Stream<Role> generateStreamFromArrayWithLimit(Role[] roles, int max) {
        return Stream.of(roles).limit(max);
    }
}
