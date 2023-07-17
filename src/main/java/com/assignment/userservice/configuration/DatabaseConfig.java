package com.assignment.userservice.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
	@Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
          .driverClassName("com.mysql.cj.jdbc.Driver")
          .url("jdbc:mysql://localhost:3306/user_profile")
          .username("root")
          .password("root")
          .build();	
    }
}
