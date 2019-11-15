package com.sheduler.dao;

import com.sheduler.entities.Tasks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssigneesMapper implements RowMapper <String> {
    public String mapRow (ResultSet resultSet, int i)  throws SQLException {
        String assignees = resultSet.getString("assignee");
        return assignees;
    }
}
