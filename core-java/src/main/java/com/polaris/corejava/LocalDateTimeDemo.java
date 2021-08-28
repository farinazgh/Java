package com.polaris.corejava;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(1978, 9, 6));
        System.out.println(LocalDate.parse("2018-02-20"));
        System.out.println(LocalDate.now().plusDays(1));
        System.out.println(LocalDate.now().plusDays(-1));
        System.out.println(LocalDate.now().plusMonths(1));
        System.out.println(LocalDate.now().plusMonths(-1));
        System.out.println(LocalDate.parse("2016-06-12").getChronology());
        System.out.println(LocalDate.parse("2018-04-01").isAfter(LocalDate.parse("2018-03-01")));
        System.out.println(LocalTime.now());

        System.out.println(LocalTime.parse("06:30"));
        System.out.println(LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS));
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalDateTime.of(2018, 12, 1, 12, 11, 23, 33));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        String formattedDateTime = dateTime.format(formatter); // "1986-04-08 12:30"
        System.out.println(formattedDateTime);
        System.out.println(ZoneId.of("Europe/Paris"));
        System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println(ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]"));
        LocalDate initialDate = LocalDate.parse("2007-05-10");
        System.out.println(initialDate.plus(Period.ofDays(5)));
        System.out.println(Period.ofDays(5));
        System.out.println(Period.ofMonths(5));
        System.out.println(Period.ofWeeks(5));
        System.out.println(Period.ofYears(5));

        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        String localDateString = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(localDateString);

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        //String to date time
        LocalDateTime stringToTime = LocalDateTime.parse("2015/01/25 06:30:00", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        //date time to string
        String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateStr);
        System.out.println(stringToTime);
    }
}
