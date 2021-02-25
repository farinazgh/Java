package com.modernjava.chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        getOrderedLowCalorieDishesNames();
        System.out.println(testStream());

        testStream2();
    }

    private static void getOrderedLowCalorieDishesNames() {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : Dish.menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
    }

    static List<String> testStream() {
        return Dish.menu
                .parallelStream()
                .filter(a -> a.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    static void testStream2() {
        List<String> threeOrderedHighCaloricDishNames =
                Dish.menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .sorted(Comparator.comparing(Dish::getName))
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeOrderedHighCaloricDishNames);
    }
}
