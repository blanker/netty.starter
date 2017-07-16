package com.dongbawen.java8.starter;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>(500*10000);
        for(int i = 0; i < 5000 * 10000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        LocalTime startTime = LocalTime.now();
        System.out.println(" * begin sort...");
        long count = list.stream().sorted().count();
        //System.out.println(count);
        System.out.println(" * end sort.");
        LocalTime endTime = LocalTime.now();

        long millis = Duration.between(startTime, endTime).toMillis();
        System.out.println(" * 耗时： "+millis+ " ms."        );

        Thread.sleep(60*1000);
    }
}
