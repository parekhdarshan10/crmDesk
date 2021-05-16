package com.nitinjyoti.configuration;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.nitinjyoti")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{

	// CONFIGUREATIN OF DATABASE USING APACHE DBCP CONNECTION POOL
	@Bean
	public BasicDataSource getDataSoure(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/darshan");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}
	
	// PASSING THE DATABASE CONNECTION TO JDBC TEMPLATE
	@Bean
	public JdbcTemplate getjdbcTemplate(){
		return new JdbcTemplate(getDataSoure());
	}
}


	