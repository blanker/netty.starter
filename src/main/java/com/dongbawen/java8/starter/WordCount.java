package com.dongbawen.java8.starter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "hello welcome", "welcome to the earth", "welcome to the moon");

        Map<String, Long> collect = list.stream().map(e -> e.split("\\s")).flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map<Boolean, Long> collect1 = list.stream().map(e -> e.split("\\s")).flatMap(Arrays::stream)
                .collect(Collectors.partitioningBy(e -> e.length() > 5, Collectors.counting()));
        System.out.println(collect1);
    }
}
