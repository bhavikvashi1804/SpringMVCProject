package com.bhavik.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bhavik.demo.jdbc.JDBCDemo;

@SpringBootApplication
public class SpringMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);
		
		JDBCDemo jdbcDemo = new JDBCDemo();
		jdbcDemo.fetchDetailsFromDB();
	}

}
