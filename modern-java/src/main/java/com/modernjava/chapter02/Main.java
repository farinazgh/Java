package com.modernjava.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(120, Color.RED));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Apple> redApples =
                filter(apples, (Apple apple) -> Color.RED.equals(apple.getColor()));
        List<Integer> evenNumbers =
                filter(numbers, (Integer i) -> i % 2 == 0);

        System.out.println(redApples);
        System.out.println(evenNumbers);
    }
}
