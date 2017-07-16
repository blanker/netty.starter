package com.dongbawen.java8.starter;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by blank on 2017/7/12.
 */
public class MyCollector<T> implements Collector<T, Map<T, T>, Map<T, T>> {
    @Override
    public Supplier<Map<T, T>> supplier() {
        System.out.println("supplier invoked.");
        return () -> {
            System.out.println(" inside supplier invoked.");
            return new HashMap<T, T>();
        };
    }

    @Override
    public BiConsumer<Map<T, T>, T> accumulator() {
        System.out.println("accumulator invoked.");
        return (map, t) -> {
            //System.out.println(" inside accumulator invoked.");
            map.put(t, t);
        };
    }

    @Override
    public BinaryOperator<Map<T, T>> combiner() {
        System.out.println("combiner invoked.");
        return (ttMap, ttMap2) -> {
            System.out.println(" inside combiner invoked.");
            ttMap.putAll(ttMap2);
            return ttMap;
        };
    }

        @Override
    public Function<Map<T, T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked.");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");
        Set<Characteristics> set = new HashSet();
        set.add(Characteristics.IDENTITY_FINISH);
        set.add(Characteristics.UNORDERED);
        set.add(Characteristics.CONCURRENT);
               return set;
       // return Sets.immutableEnumSet(, Characteristics.UNORDERED, Characteristics.CONCURRENT);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1100*10000; i++){
            list.add("hello"+i);
            list.add("world"+i);
            list.add("nihao"+i);
            list.add("welcome"+i);
        }
        System.out.println(list.size());
        //list.forEach(System.out::println);

        Map<String, String> map = list.parallelStream().collect(new MyCollector<>());
        //System.out.println(map);
    }
}
