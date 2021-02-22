package com.modernjava.chapter02;

public class PrettyPrintApplePredicate implements PrettyPrintPredicate {
    @Override
    public String prettyPrint(Apple apple) {
        StringBuilder sb = new StringBuilder();
        sb.append("color is: ");
        if (apple.getColor().equals(Color.RED)) sb.append("RED");
        else sb.append("GREEN");
        if (apple.getWeight() > 150) sb.append(" apple is heavy");
        else sb.append(" apple is light");
        return sb.toString();
    }
}
