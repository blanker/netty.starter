package com.dongbawen.java8.starter;

@FunctionalInterface
public interface MyFunction<T, R> {

    public R apply(T t);

    default <V> MyFunction<T, V> andThen(MyFunction<R, V> after){
        return t-> after.apply(apply(t));
    }

    default <V> MyFunction<V, R> compose(final MyFunction<V, T> before){

//        return new MyFunction<V, R>(){
//
//            @Override
//            public R apply(V v) {
//                T t = before.apply(v);
//                R r = MyFunction.this.apply(t);
//                return  r;
//            }
//        };

        return (V v) -> {
            T t = before.apply(v);
            return MyFunction.this.apply(t);

        };
//        return new MyFunction<V, R>(){
//
//            @Override
//            public R apply(V v) {
//                T t = before.apply(v);
//                R r = MyFunction.this.apply(t);
//                return  r;
//            }
//        };


        //return t-> apply(before.apply(t));
    }

    static <T> MyFunction<T, T> identify() {
        return t->t;
    }
}
