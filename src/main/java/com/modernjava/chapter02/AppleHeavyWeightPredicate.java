package com.modernjava.chapter02;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        System.out.println("apple is AppleHeavyWeightPredicate");
        return apple.getWeight() > 150;
    }
}