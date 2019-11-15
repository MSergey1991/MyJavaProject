package com.sheduler.dao;


import com.sheduler.entities.Tasks;

import java.util.Date;
import java.util.List;

public interface TaskDao  {

    void saveTask (String assignee, String  summary, Date startDate, Date endDate);

    List<Tasks> findAll ();
}


