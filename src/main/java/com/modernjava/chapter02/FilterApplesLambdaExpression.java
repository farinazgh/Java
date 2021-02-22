package com.modernjava.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApplesLambdaExpression {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(120, Color.RED));

        List<Apple> result = filterApples(apples, (Apple a) -> a.getColor().equals(Color.RED));
        System.out.println(result);

    }

    static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) result.add(apple);
        }
        return result;
    }
}
