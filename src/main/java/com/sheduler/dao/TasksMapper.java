package com.sheduler.dao;

import com.sheduler.entities.Tasks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TasksMapper implements RowMapper<Tasks> {
    public Tasks mapRow(ResultSet resultSet, int i) throws SQLException {
        Tasks tasks = new Tasks();
        tasks.setId(resultSet.getInt("id"));
        tasks.setSummary(resultSet.getString("summary"));
        tasks.setStartDate(resultSet.getDate("startDate"));
        tasks.setEndDate(resultSet.getDate("endDate"));
        tasks.setAssignee(resultSet.getString("assignee"));
        return tasks;
    }
}
