package com.assignment.userservice.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Configuration
	public class DataSourceConfig {
	    @Bean
	    public DataSource getDataSource() {
	        return DataSourceBuilder.create()
	          .driverClassName("com.mysql.cj.jdbc.Driver")
	          .url("jdbc:mysql://localhost:3306/user_profile")
	          .username("root")
	          .password("root")
	          .build();	
	    }
	}
}
