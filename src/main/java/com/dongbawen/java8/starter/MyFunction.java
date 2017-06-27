package com.dongbawen.java8.starter;

@FunctionalInterface
public interface MyFunction<T, R> {

    public R apply(T t);

    default <V> MyFunction<T, V> andThen(MyFunction<R, V> after){
        return t-> after.apply(apply(t));
    }

    default <V> MyFunction<V, R> compose(MyFunction<V, T> before){
        return t-> apply(before.apply(t));
    }

    static <T> MyFunction<T, T> identify() {
        return t->t;
    }
}
