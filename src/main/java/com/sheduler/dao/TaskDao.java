package com.sheduler.dao;

import com.sheduler.entities.Tasks;

import java.util.Date;
import java.util.List;

public interface TaskDao {

    void saveTask(String assignee, String summary, Date startDate, Date endDate,  boolean parametersValidationResult);

    List<Tasks> findAll();

    List<Tasks> findBySearchFilter(String assignee, Date startDate, Date endDate, String period);

    List<String> findAllAssignees();
}


