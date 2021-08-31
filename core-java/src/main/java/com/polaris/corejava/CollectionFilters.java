package com.polaris.corejava;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectionFilters {
    public static <T> Collection<T> filterCollectionHelperMethod(Collection<T> collection) {
        Predicate<Integer> streamPredicate = item -> item % 2 != 0;
        return collection.stream().
                filter((Predicate<? super T>) streamPredicate).collect(Collectors.toList());
    }

    static public Collection<Integer> findEvenNumbersUsingHelperMethod(Collection<Integer> collection) {
        return collection.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
    }

    public static long findIterableSize(final Iterable data) {

        return StreamSupport.stream(data.spliterator(), false).count();
    }

    public Stream<String> collectionAsStream(Collection<String> collection) {
        return collection == null ? Stream.empty() : collection.stream();
    }

    public List<String> streamFilterAndCollector() {
        Collection<String> names = new ArrayList<>();
        names.add("John");
        names.add("Ana");
        names.add("Mary");
        names.add("Anthony");
        names.add("Mark");
        return names
                .stream()
                .map(String::toLowerCase)
                .filter(str -> !str.startsWith("a"))
                .collect(Collectors.toList());
    }

}
