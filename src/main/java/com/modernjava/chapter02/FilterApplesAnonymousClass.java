package com.modernjava.chapter02;

import java.util.Arrays;
import java.util.List;

import static com.modernjava.chapter02.Color.RED;
import static com.modernjava.chapter02.FilterApplesPredicate.filterApples;

public class FilterApplesAnonymousClass {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(120, Color.RED));
        List<Apple> redApples = filterApples(apples, new ApplePredicate() {
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });
        System.out.println(redApples);
    }
}
