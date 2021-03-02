package com.modernjava.chapter05;

import com.modernjava.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.FISH),
            new Dish("prawns", false, 300, Dish.Type.MEAT),
            new Dish("rice", true, 350, Dish.Type.VEGETARIAN),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.VEGETARIAN));

    private static void filteringUniqueElements() {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 3);
        list.stream().distinct().forEach(System.out::println);
    }

    /*
    notice that the initial list was already sorted on the number of calories!
    The downside of using the
    operation here is that you need to iterate through the
    filter
    whole stream and the predicate is applied to each element
     */
    private static void testSlicing() {
        specialMenu.stream().filter((Dish dish) -> dish.getCalories() < 320).forEach(System.out::println);
    }

    //it stops once it has found an element that fails to match
    private static void testTakeWhile() {
        specialMenu.stream().takeWhile((Dish dish) -> dish.getCalories() < 320).forEach(System.out::println);
    }

    private static void testDropWhile() {
        specialMenu.stream().dropWhile((Dish dish) -> dish.getCalories() < 320).forEach(System.out::println);
    }

    private static void testLimitSkip() {
        System.out.println("###################");
        specialMenu.stream().filter((Dish dish) -> dish.getCalories() < 320).limit(1).forEach(System.out::println);
        System.out.println("###################");
        specialMenu.stream().filter((Dish dish) -> dish.getCalories() < 320).skip(1).forEach(System.out::println);
    }

    //How would you use streams to filter the first two meat dishes?
    private static void test() {
        specialMenu
                .stream()
                .filter((Dish dish) -> dish.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .forEach(System.out::println);
    }

    private static void testMap() {
        List<String> list = Arrays.asList("hello", "modern", "java");
//        list.stream().map((String str) -> str.length()).forEach(System.out::println);
        list.stream().map(String::length).forEach(System.out::println);
        System.out.println("=================================");
        //it is ok to use two maps
        specialMenu.stream().map(Dish::getName).map(String::length).forEach(System.out::println);
    }

    private static void testFlatMap() {
        List<String> words = Arrays.asList("hello", "modern", "java");
        //does not work
/*
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .forEach(System.out::println);

                returns Stream<String[]>
                we want Stream<String>

        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

                returns List<Stream<String>>
                we want Stream<String>
 */
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
        System.out.println("==================================");
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }

    static void returnSquare() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().map((Integer i) -> Math.pow(i, 2)).forEach(System.out::println);
    }

    static void listOfPairs() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).forEach(System.out::println);
    }

    public static void main(String[] args) {
        filteringUniqueElements();
        testSlicing();
        System.out.println("=====================");
        testTakeWhile();
        System.out.println("=====================");
        testDropWhile();
        System.out.println("=====================");
        testLimitSkip();
        System.out.println("=====================");
        test();
        System.out.println("=====================");
        testMap();
        System.out.println("===================");
        testFlatMap();
        System.out.println("===================");
        returnSquare();
        System.out.println("===================");
        listOfPairs();
    }
}
