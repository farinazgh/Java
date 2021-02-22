package com.modernjava.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApplesPredicate {
    /*
    the behavior of the filterApples method is parameterized
     */

    static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) result.add(apple);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(120, Color.RED));
        System.out.println(filterApples(apples, new AppleGreenColorPredicate()));
        System.out.println(filterApples(apples, new AppleHeavyWeightPredicate()));
        System.out.println(filterApples(apples, new AppleRedAndHeavyPredicate()));
        System.out.println("***********************");
        prettyPrintApple(apples, new PrettyPrintApplePredicate());
    }
    public static void prettyPrintApple(List<Apple> inventory, PrettyPrintApplePredicate predicate) {
        for(Apple apple: inventory) {
            String output = predicate.prettyPrint(apple);
            System.out.println(output);
        }
    }
}
