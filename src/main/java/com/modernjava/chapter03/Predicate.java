package com.modernjava.chapter03;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}