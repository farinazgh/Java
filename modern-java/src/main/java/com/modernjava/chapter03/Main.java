package com.modernjava.chapter03;

import com.google.common.util.concurrent.Uninterruptibles;
import com.modernjava.chapter02.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Main {
    public static List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> results = new ArrayList<String>();
        for (String t : list) {
            if (predicate.test(t)) results.add(t);
        }
        return results;
    }

    public static void forEach(List<Integer> numbers, Consumer consumer) {
        for (Integer number : numbers) {
            consumer.accept(number);
        }
    }

    public <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }

    public static void testSupplier() {
        System.out.println(9d);
        Supplier<Double> lazyValue = () -> {
            Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
            return 9d;
        };
        Double valueSquared = squareLazy(lazyValue);
        System.out.println(valueSquared);
    }

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> listOfStrings = Arrays.asList("hi", "", "test", "");
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmpty);

        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6, 7);
        forEach(numbers, (Object i) -> System.out.print(i + ","));
        System.out.println();

        List<Integer> l = new Main().map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println(l);
        IntPredicate evenNumbers = (int i) -> (i % 2) == 0;//True (no boxing)
        evenNumbers.test(1000);
        //com.modernjava.chapter03.Predicate oddNumbers = (Integer i) -> i % 2 != 0; //false no autoboxing

        testSupplier();
    }
}
