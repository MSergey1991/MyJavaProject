package com.sheduler.dao;

import com.sheduler.entities.Tasks;
import com.sheduler.utilities.TimeSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Calendar;
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

    public List<Tasks> findBySearchFilter(String assignee, Date startDate, Date endDate, String period) {
        if(!period.isEmpty()){
            startDate = selectStartDate(period);
            endDate = selectEndDate(period);
        }
        String sql;
        if (!assignee.isEmpty() && startDate != null && endDate != null) {
            sql = "SELECT * FROM tasks WHERE assignee=? AND startDate <=? AND endDate >=?";
            return jdbcTemplate.query(sql, new TasksMapper(), assignee, endDate, startDate);
        } else if (!assignee.isEmpty() && ((startDate == null && endDate == null) || (startDate != null && endDate == null) || (startDate == null && endDate != null))) {
            sql = "SELECT * FROM tasks WHERE assignee=?";
            return jdbcTemplate.query(sql, new TasksMapper(), assignee);
        } else if (assignee.isEmpty() && startDate != null && endDate != null) {
            sql = "SELECT * FROM tasks WHERE startDate <=? AND endDate >=?";
            return jdbcTemplate.query(sql, new TasksMapper(), endDate, startDate);
        } else
            sql = "SELECT * FROM tasks";
        return jdbcTemplate.query(sql, new TasksMapper());
    }

    @Override
    public List<String> findAllAssignees() {
        String sql = "SELECT DISTINCT assignee FROM tasks";
        return jdbcTemplate.query(sql, new AssigneesMapper());
    }

    Date selectStartDate(String period){
        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        TimeSetter.setMinimumTimeOfTheStartDate(calendar);

        switch (period) {
            case "lastQuarter": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3 - 3);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "lastMonth": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "lastWeek": {
                calendar.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)-1);
                calendar.set(Calendar.DAY_OF_WEEK, 2);
                startDate = calendar.getTime();
            }
            break;
            case "currentQuarterToDate": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "currentMonthToDate": {
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "currentWeekToDate": {
                calendar.set(Calendar.DAY_OF_WEEK, 2);
                startDate = calendar.getTime();
            }
            break;
        }
        return startDate;
    }

    Date selectEndDate(String period){
        Date endDate = new Date();
        Calendar calendar = Calendar.getInstance();
        TimeSetter.setMaximalTimeOfTheEndDate(calendar);
        switch (period) {
            case "lastQuarter": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3 - 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                endDate = calendar.getTime();
            }
            break;
            case "lastMonth": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                endDate = calendar.getTime();
            }
            break;
            case "lastWeek": {
                calendar.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)-1);
                calendar.set(Calendar.DAY_OF_WEEK, 8);
                endDate = calendar.getTime();
            }
            break;
            case "currentQuarterToDate": {
                endDate = calendar.getTime();
            }
            break;
            case "currentMonthToDate": {
                endDate = calendar.getTime();
            }
            break;
            case "currentWeekToDate": {
                endDate = calendar.getTime();
            }
            break;
        }
        return endDate;
    }
}
