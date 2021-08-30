package com.polaris.corejava;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateComparison {
    public static boolean isSameDay(LocalDateTime timestamp, LocalDate localDateToCompare) {
        return timestamp.toLocalDate().isEqual(localDateToCompare);
    }

    public static boolean isSameDay(LocalDateTime timestamp, LocalDateTime timestampToCompare) {
        //return timestamp.toLocalDate().getDayOfMonth() == timestampToCompare.getDayOfMonth();
        return timestamp.truncatedTo(DAYS).isEqual(timestampToCompare.truncatedTo(DAYS));

    }

    public static void main(String[] args) {

    }
}
