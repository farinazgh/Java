package com.polaris.corejava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombiningCollections {
    Object[] combine1(Object[] array1, Object[] array2) {
        Object[] combinedArray = new Object[array1.length + array2.length];
        System.arraycopy(array1, 0, combinedArray, 0, array1.length);
        System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);
        return combinedArray;
    }

    Object[] combine2(Object[] array1, Object[] array2) {
        return Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray();
    }

    List<Object> combineList(List<Object> list1, List<Object> list2) {
        list1.addAll(list2);
        return list1;
    }

    List<Object> combineList2(List<Object> list1, List<Object> list2) {
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }

    public static Map<String, String> usingPlainJava(Map<String, String> first, Map<String, String> second) {
        Map<String, String> combined = new HashMap<>();
        combined.putAll(first);
        combined.putAll(second);
        return combined;
    }

    public static Map<String, String> usingJava8ForEach(Map<String, String> first, Map<String, String> second) {
        second.forEach((key, value) -> first.merge(key, value, String::concat));
        return first;
    }
    public static Set<Object> usingNativeJava(Set<Object> first, Set<Object> second) {
        Set<Object> combined = new HashSet<>();
        combined.addAll(first);
        combined.addAll(second);
        return combined;
    }

    public static Set<Object> usingJava8ObjectStream(Set<Object> first, Set<Object> second) {
        return Stream.concat(first.stream(), second.stream()).collect(Collectors.toSet());
    }
}
