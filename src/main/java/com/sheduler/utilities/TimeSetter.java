package com.sheduler.utilities;

import java.util.Calendar;

public class TimeSetter {

    public static Calendar setMaximalTimeOfTheEndDate(Calendar calendar) {
        calendar.set(Calendar.AM_PM, 1);
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar;
    }

    public static Calendar setMinimumTimeOfTheStartDate(Calendar calendar) {
        calendar.set(Calendar.AM_PM, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar;
    }
}
