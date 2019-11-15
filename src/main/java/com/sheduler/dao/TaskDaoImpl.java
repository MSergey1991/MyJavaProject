package com.sheduler.dao;

import com.sheduler.entities.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    public final JdbcTemplate jdbcTemplate;


    @Autowired
    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveTask(String assignee, String summary, Date startDate, Date endDate) {
        String sql = "INSERT INTO tasks (assignee, summary, startDate, endDate) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, assignee, summary, startDate, endDate);
    }

    public List<Tasks> findAll() {
        String sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, new TasksMapper());
    }

    public List<Tasks> findBySearchFilter(String assignee, Date startDate, Date endDate) {
        String sql;
        if (!assignee.isEmpty() && startDate != null && endDate != null) {
            sql = "SELECT * FROM tasks WHERE assignee=? AND startDate >=? AND endDate <=?";
            return jdbcTemplate.query(sql, new TasksMapper(), assignee, startDate, endDate);
        } else if (!assignee.isEmpty() && ((startDate == null && endDate == null) || (startDate != null && endDate == null) || (startDate == null && endDate != null))) {
            sql = "SELECT * FROM tasks WHERE assignee=?";
            return jdbcTemplate.query(sql, new TasksMapper(), assignee);
        } else if (assignee.isEmpty() && startDate != null && endDate != null) {
            sql = "SELECT * FROM tasks WHERE startDate >=? AND endDate <=?";
            return jdbcTemplate.query(sql, new TasksMapper(), startDate, endDate);
        } else
            sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, new TasksMapper());
    }
}
