package com.sheduler.utilities;

import java.util.Date;

public class Validator {
    public static boolean validateTaskParameters(String assignee, String summary, Date startDate, Date endDate) {
        if (startDate == null || endDate == null || assignee.isEmpty() || summary.isEmpty() || startDate.after(endDate)) {
            return false;
        } else {
            return true;
        }
    }
}