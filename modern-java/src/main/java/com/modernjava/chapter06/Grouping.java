package com.modernjava.chapter06;

import com.modernjava.Dish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.modernjava.Dish.menu;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

enum CaloricLevel {
    DIET, NORMAL, FAT
}


public class Grouping {
    public static final Map<String, List<String>> dishTags = new HashMap<>();

    static {
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
    }

    static void testGrouping() {
        Map<Dish.Type, List<Dish>> map = menu.stream().collect(groupingBy(Dish::getType));
        for (Map.Entry<Dish.Type, List<Dish>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    static void testGrouping2() {
        // instead of using functional refrence we use a lambda expression
        // remeber to write a full function without a name
        Map<CaloricLevel, List<Dish>> dishes = menu
                .stream()
                .collect(groupingBy((Dish dish) -> {
                    if (dish.getCalories() < 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() < 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println(dishes);
    }

    static void testGrouping3() {
        Map<Dish.Type, List<Dish>> dishes = menu
                .stream()
                .filter((Dish dish) -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));

        for (Map.Entry<Dish.Type, List<Dish>> entry : dishes.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    static void testGrouping4() {
        Map<Dish.Type, List<Dish>> dishes = menu
                .stream()
                .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        for (Map.Entry<Dish.Type, List<Dish>> entry : dishes.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    static void testGrouping5() {
        Map<Dish.Type, List<String>> dishesname =
                menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println(dishesname);
    }

    static void testGrouping6() {
        Map<Dish.Type, Set<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish -> dishTags.get(dish.getName()).stream(),
                                        toSet())));
        System.out.println(dishNamesByType);
    }

    static void testGrouping7() {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(
                        dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            return CaloricLevel.FAT;
                        }
                ));
        System.out.println(dishesByCaloricLevel);
    }

    static void testGrouping8() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                })
                        )
                );
        System.out.println(dishesByTypeCaloricLevel);
    }

    public static void main(String[] args) {
        System.out.println("************* testGrouping **************");
        testGrouping();
        System.out.println("************* testGrouping2 **************");
        testGrouping2();
        System.out.println("*********** testGrouping3 ****************");
        testGrouping3();
        System.out.println("************ testGrouping4 ***************");
        testGrouping4();
        System.out.println("************ testGrouping6 ***************");
        testGrouping6();
        System.out.println("************ testGrouping7 ***************");
        testGrouping7();
        testGrouping8();
    }
}
