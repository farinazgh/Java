package com.modernjava.chapter02;

public class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        System.out.println("apple is AppleGreenColorPredicate");
        return (apple.getColor().equals(Color.GREEN));
    }
}