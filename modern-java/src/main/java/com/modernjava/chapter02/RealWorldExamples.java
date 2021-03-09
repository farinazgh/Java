package com.modernjava.chapter02;

import java.util.Arrays;
import java.util.List;

public class RealWorldExamples {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(120, Color.RED));

        apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(apples);
    }
}
