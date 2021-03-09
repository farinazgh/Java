package com.modernjava.chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {
    static void streamOfValues() {
        Stream
                .of("hi", "I", "love", "programming!")
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    void streamOfNullable() {
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = (homeValue == null) ? Stream.empty() : Stream.of(homeValue);

        homeValueStream = Stream.ofNullable(System.getProperty("home"));//java 9 solution

        Stream<String> values = Stream
                .of("config", "home", "user")
                .flatMap((key) -> Stream.ofNullable(System.getProperty(key)));
    }

    static int streamOfArray() {
        int[] array = {1, 2, 3, 4, 5, 6};
        return Arrays.stream(array).sum();
    }

    static void streamOfFiles() throws IOException {
        Files
                .lines(Paths.get("C:\\Users\\farin\\OneDrive\\Desktop\\xuan.txt"))
                .forEach(System.out::println);

        long uniqueWords = 0;
        //Streams are AutoCloseable so there’s no need for try-finally
        try (Stream<String> lines =
                     Files.lines(Paths.get("C:\\Users\\farin\\OneDrive\\Desktop\\xuan.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("unique words:" + uniqueWords);
    }

    static void fibonacci() {
        Stream.iterate(
                new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]}
        )
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    static void iterateWithAPredicate() {
        IntStream
                .iterate(0, n -> n < 100, n -> n + 4)//note that limit is no longer required since we use n<100
                .forEach(System.out::println);
/*
        this works but predicate is cleaner
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

       ** this code never terminates
        no way to know "in the filter" that the numbers continue to increase
        IntStream.iterate(0, n -> n + 4)
        .filter(n -> n < 100)
        .forEach(System.out::println);
         */
    }

    public static void main(String[] args) {
        streamOfValues();
        System.out.println(streamOfArray());
        try {
            streamOfFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("*******************");
        fibonacci();
        System.out.println("*******************");

        iterateWithAPredicate();
    }
}
