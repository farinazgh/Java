package com.modernjava.behaviorparameterization;

public class AppleHeavyAndRedPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return (apple.getWeight() > 100) && (apple.getColor().equals("red"));
    }
}
