package com.modernjava.chapter05;

import com.modernjava.Dish;

import java.util.stream.IntStream;

public class NumericRanges {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 99).forEach(System.out::println);
    }

    void testPrimitiveSpec() {
        //default stream does not have sum, min or max since it does not make sense to add two dishes for example

        Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        //but mapToInt does have min max and sum :)
        Dish.menu.stream().mapToInt(Dish::getCalories).sum();
    }
}
