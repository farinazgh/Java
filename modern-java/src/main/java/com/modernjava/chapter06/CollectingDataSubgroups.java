package com.modernjava.chapter06;

import com.modernjava.Dish;

import java.util.Map;

import static com.modernjava.Dish.menu;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CollectingDataSubgroups {
    static void testSubGroups() {
        Map<Dish.Type, Long> map = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(map);
    }

    public static void main(String[] args) {
        testSubGroups();
    }
}
