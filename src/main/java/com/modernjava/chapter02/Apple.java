package com.modernjava.chapter02;

import lombok.Getter;

@Getter
public class Apple {
    private Integer weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public String toString() {
        return String.format("Apple{color=%s, weight=%d}", color, weight);
    }
}