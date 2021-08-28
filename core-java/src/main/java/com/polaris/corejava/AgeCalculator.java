package com.polaris.corejava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.joda.time.Years;

public class AgeCalculator {

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        // validate inputs ...
        return Period.between(birthDate, currentDate).getYears();
    }

    public int calculateAgeWithJodaTime(org.joda.time.LocalDate birthDate, org.joda.time.LocalDate currentDate) {
        // validate inputs ...
        return Years.yearsBetween(birthDate, currentDate).getYears();
    }

    public int calculateAgeWithJava7(Date birthDate, Date currentDate) {
        // validate inputs ...
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        System.out.println(d1);
        int d2 = Integer.parseInt(formatter.format(currentDate));
        System.out.println(d2);

        return (d2 - d1) / 10000;
    }

    public static void main(String[] args) {
        AgeCalculator ageCalculator = new AgeCalculator();
        System.out.println(ageCalculator.calculateAge(
                LocalDate.of(2008, 5, 20),
                LocalDate.of(2018, 9, 20)));
        System.out.println(ageCalculator.calculateAgeWithJodaTime(
                new org.joda.time.LocalDate(2008, 5, 20),
                new org.joda.time.LocalDate(2018, 9, 20)));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date birthDate = null;
        Date currentDate = null;
        try {
            birthDate = sdf.parse("2008-05-20");
            currentDate = sdf.parse("2018-09-20");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(ageCalculator.calculateAgeWithJava7(birthDate, currentDate));

    }
}