package com.modernjava.behaviorparameterization;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apple {

    private final int weight;
    private final String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}