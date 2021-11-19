package com.bhavik.demo;

import javax.persistence.OneToOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bhavik.demo.jdbc.JDBCDemo;
import com.bhavik.demo.jdbc.OneToOneDemo;

@SpringBootApplication
public class SpringMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);
		
		//OneToOneDemo.storeNewObject();
		OneToOneDemo.readInstructorObject();
	}

}
