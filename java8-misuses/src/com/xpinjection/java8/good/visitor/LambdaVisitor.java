package com.xpinjection.java8.good.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Alimenkou Mikalai
 */
public class LambdaVisitor<A> implements Function<Object, A> {
    private final Map<Class<?>, Function<Object, A>> functions = new HashMap<>();

    /**
     * 被访问的受主
     * @param clazz
     * @return
     * @param <B>
     */
    public <B> Acceptor<A, B> on(Class<B> clazz) {
        return new Acceptor<>(this, clazz);
    }

    /**
     * 调用
     * @param o the function argument
     * @return
     */
    @Override
    public A apply(Object o) {
        return functions.get(o.getClass()).apply(o);
    }

    public static class Acceptor<A, B> {
        private final LambdaVisitor visitor;
        private final Class<B> clazz;

        public Acceptor(LambdaVisitor<A> visitor, Class<B> clazz) {
            this.visitor = visitor;
            this.clazz = clazz;
        }
        // 添加
        @SuppressWarnings("unchecked")
        public LambdaVisitor<A> then(Function<B, A> f) {
            visitor.functions.put(clazz, f);
            return visitor;
        }
    }
}
