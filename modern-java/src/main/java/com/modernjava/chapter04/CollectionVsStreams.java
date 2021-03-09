package com.modernjava.chapter04;

import com.modernjava.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionVsStreams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hi", "my", "name", "is", "slim", "shady!");
        Stream stream = list.stream();
        stream.forEach(System.out::println);
        //java.lang.IllegalStateException: stream has already been operated upon or closed
        stream.forEach(System.out::println);
    }

    List<String> java7rep() {
        List<String> highCaloricDishes = new ArrayList<>();
        for (Dish dish : Dish.menu) {
            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }
        return highCaloricDishes;
    }

    List<String> java8Rep() {
        return Dish.menu
                .stream()
                .filter((Dish dish) -> dish.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
