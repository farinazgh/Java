package com.modernjava.chapter05;

import com.modernjava.Dish;

public class MapReduce {
    //count the number of dishes in a stream using the map and reduce methods
    static void countDishes() {
        Integer count = Dish.menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
        System.out.println(count);
        System.out.println(Dish.menu.stream().count());
        System.out.println((long) Dish.menu.size());
    }
}
