package com.modernjava.chapter06;

import com.modernjava.Dish;

import java.util.List;
import java.util.Map;

import static com.modernjava.Dish.menu;
import static java.util.stream.Collectors.groupingBy;

public class MultilevelGrouping {
    static void testMultiLevelGrouping() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel
                = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        })));

        for (Map.Entry<Dish.Type, Map<CaloricLevel, List<Dish>>> entry:dishesByTypeCaloricLevel.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }
    }

    public static void main(String[] args) {
        testMultiLevelGrouping();
    }
}
