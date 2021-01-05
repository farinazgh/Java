package com.modernjava.behaviorparameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Apple> inventory = Arrays.asList(
            new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red")
    );

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        strategyPattern();
    }

    private static void strategyPattern() {
    /*
    Pass a strategy to the filter method: filter
    the apples by using the boolean expression encapsulated within the ApplePredicate object.
     */
        List<Apple> green = filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> heavy = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> readAndHeavy = filterApples(inventory, new AppleHeavyAndRedPredicate());
        System.out.println(green);
        System.out.println(heavy);
        System.out.println(readAndHeavy);
        List<Apple> red = filterApples(inventory, (Apple apple) -> apple.getColor().equals("red"));
        System.out.println(red);
        System.out.println(inventory);

        inventory.sort((Apple a1, Apple a2) -> a2.getWeight() - a1.getWeight());
        System.out.println(inventory);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
