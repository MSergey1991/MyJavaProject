package com.sheduler.configuration;

import com.sheduler.dao.TaskDao;
import com.sheduler.dao.TaskDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
public class SpringConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/testTaskDB?useSll=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("***");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());

    }

    @Bean
    public TaskDao taskDao(){
        return new TaskDaoImpl (jdbcTemplate());
    }

}
