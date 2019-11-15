package com.sheduler.dao;


import java.util.Date;

public interface TaskDao  {

    void saveTask (String assignee, String  summary, Date startDate, Date endDate);
}
