package com.cvent.foodflick;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration public class TestConfiguration {
    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/testfoodflick"); // Replace with your actual local PostgreSQL URL
        dataSource.setUsername("postgres"); // Replace with your PostgreSQL username
        dataSource.setPassword(""); // Replace with your PostgreSQL password
        return dataSource;
    }
}