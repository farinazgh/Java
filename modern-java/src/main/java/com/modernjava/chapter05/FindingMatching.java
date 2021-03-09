package com.modernjava.chapter05;

import com.modernjava.Dish;

import java.util.Optional;

public class FindingMatching {
    /*
allMatch
anyMatch
noneMatch
findFirst
findAny
 */
    private static void testMatch() {
        if (Dish.menu.stream().allMatch(Dish::isVegetarian)) System.out.println("all vegeterian");
        else if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) System.out.println("some are vegeterin");
    }

    private static void testNonMatch() {
        System.out.println(
                Dish.menu
                        .stream()
                        .noneMatch((Dish dish) -> dish.getType().equals(Dish.Type.SOUP)));
    }

    private static void testFindAny() {
        Optional<Dish> dish = Dish.menu.stream().filter(Dish::isVegetarian).findAny();
//        if (dish.isPresent()) System.out.println(dish.get());
        dish.ifPresent(System.out::println);
        Optional<Dish> saladDish = Dish.menu.stream().filter((Dish d) -> d.getType().equals(Dish.Type.SOUP)).findAny();

        if (saladDish.isPresent()) System.out.println(saladDish.get());
        else System.out.println("no soup for you!");
    }

    private static void testFindFisrt() {
        Optional<Dish> firstFish = Dish.menu
                .stream()
                .filter((Dish dish) -> dish.getType().equals(Dish.Type.FISH))
                .findFirst();
        firstFish.ifPresent(System.out::println);
        Optional<Dish> saladDish = Dish.menu.stream().filter((Dish d) -> d.getType().equals(Dish.Type.SOUP)).findFirst();

        if (saladDish.isPresent()) System.out.println(saladDish.get());
        else System.out.println("no soup for you!");

    }

    public static void main(String[] args) {
        testMatch();
        testNonMatch();
        testFindAny();
        testFindFisrt();
    }
}
