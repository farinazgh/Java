package com.modernjava;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        System.out.println(numbers
                .stream()
                .filter((Integer a) -> (a % 2 == 0))
                .distinct()
                .collect(Collectors.toList()));
        numbers.stream().filter((Integer a) -> (a % 2 == 0)).distinct().forEach(System.out::println);
    }
}
