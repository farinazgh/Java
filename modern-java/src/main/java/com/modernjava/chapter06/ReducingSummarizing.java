package com.modernjava.chapter06;

import com.modernjava.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;

import static java.util.stream.Collectors.*;

public class ReducingSummarizing {
    static void findMaxMin() {
        Comparator comparator = Comparator.comparingInt(Dish::getCalories);
        System.out.println(Dish.menu.stream().collect(maxBy(comparator)));
    }

    static void summarization() {
        System.out.println("sum of calories:" + Dish.menu.stream().collect(summingInt(Dish::getCalories)));
        System.out.println("sum of calories:" + (Integer) Dish.menu.stream().mapToInt(Dish::getCalories).sum());
    }

    static void averaging() {
        System.out.println("the avg of calories is:" + Dish.menu.stream().collect(averagingDouble(Dish::getCalories)));
        System.out.println("the avg of calories is:" + Dish.menu.stream().mapToDouble(Dish::getCalories).average());

    }

    static void testIntSummaryStatistics() {
        IntSummaryStatistics summaryStatistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(summaryStatistics);
    }

    static void testJoining() {
        System.out.println(Dish.menu.stream().map(Dish::getName).collect(joining(",")));
    }

    public static void main(String[] args) {
        findMaxMin();
        summarization();
        averaging();
        testIntSummaryStatistics();
        testJoining();
    }
}
