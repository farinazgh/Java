package com.polaris.corejava;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;

public class AddHoursToDate {

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public Date addHoursToDateUsingInstant(Date date, int hours) {
        return Date.from(date.toInstant().plus(Duration.ofHours(hours)));
    }

    public LocalDateTime addHoursToLocalDateTime(LocalDateTime localDateTime, int hours) {
        return localDateTime.plusHours(hours);
    }

    public LocalDateTime subtractHoursToLocalDateTime(LocalDateTime localDateTime, int hours) {
        return localDateTime.minusHours(hours);
    }

    public ZonedDateTime addHoursToZonedDateTime(ZonedDateTime zonedDateTime, int hours) {
        return zonedDateTime.plusHours(hours);
    }

    public ZonedDateTime subtractHoursToZonedDateTime(ZonedDateTime zonedDateTime, int hours) {
        return zonedDateTime.minusHours(hours);
    }

    public Instant addHoursToInstant(Instant instant, int hours) {
        return instant.plus(hours, ChronoUnit.HOURS);
    }

    public Instant subtractHoursToInstant(Instant instant, int hours) {
        return instant.minus(hours, ChronoUnit.HOURS);
    }

    public Date addHoursWithApacheCommons(Date date, int hours) {
        return DateUtils.addHours(date, hours);
    }

    public static void main(String[] args) {
        AddHoursToDate addHoursToDateObj = new AddHoursToDate();
        Date actualDate = new GregorianCalendar(2018, Calendar.JUNE, 25, 5, 0).getTime();
        Date expectedDate = new GregorianCalendar(2018, Calendar.JUNE, 25, 7, 0).getTime();

        System.out.println(addHoursToDateObj.addHoursToJavaUtilDate(actualDate, 2).equals(expectedDate));
        Date Minus = new GregorianCalendar(2018, Calendar.JUNE, 25, 3, 0).getTime();
        System.out.println(addHoursToDateObj.addHoursToJavaUtilDate(actualDate, -2).equals(Minus));

        Instant actualValue = Instant.parse("2018-06-25T07:12:35Z");
        Instant expectedValue = Instant.parse("2018-06-25T05:12:35Z");

        System.out.println(addHoursToDateObj.subtractHoursToInstant(actualValue, 2).equals(expectedValue));
    }
}
