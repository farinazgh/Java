package com.polaris.corejava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddOneDay {
    public static String addOneDayCalendar(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.DATE, 1);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String addOneDay(String date) {
        return LocalDate.parse(date).plusDays(1).toString();
    }

    public String formatDate(GregorianCalendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
        //format(DateTimeFormatter.ofPattern("d MMM uuuu"));
    }
}
