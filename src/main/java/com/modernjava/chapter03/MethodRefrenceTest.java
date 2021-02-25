package com.modernjava.chapter03;

import com.modernjava.chapter02.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

import static java.lang.Character.isDigit;

public class MethodRefrenceTest {
    static List<String> list = Arrays.asList("a", "A", "b", "B", "c");

    private static void sortLambda() {
        list.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println(list);
    }

    private static void sort() {
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }

    private static void sortUsingMethodRef() {
        list.sort(String::compareTo);
        System.out.println(list);
    }

    void testLambda() {
        ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        Predicate<String> startsWithNumber = (String string) -> this.startsWithNumber(string);
    }

    //in method refrence version we removed the argument
    void testMethodRefrence() {
        ToIntFunction<String> stringToInt = Integer::parseInt;
        BiPredicate<List<String>, String> contains = List::contains;
        Predicate<String> startsWithNumber = this::startsWithNumber;
    }

    private boolean startsWithNumber(String string) {
        return isDigit(string.charAt(0));
    }

    public List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }

    private void testConstructorMethodRefrence() {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
    }

    public static void main(String[] args) {

    }
}
