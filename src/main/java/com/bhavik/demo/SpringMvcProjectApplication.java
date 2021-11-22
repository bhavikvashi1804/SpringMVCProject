package com.bhavik.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bhavik.demo.jdbc.OneToManyDemo;

@SpringBootApplication
public class SpringMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);
		
		//OneToOneDemo.storeNewObject();
		//OneToOneDemo.readInstructorObject();
		//OneToOneDemo.deleteInstructorDetail();
		
		//OneToManyDemo.storeNewObject();
		//OneToManyDemo.addNewCourse(1);
		//OneToManyDemo.getCoursesOfInstructor(1);
		//OneToManyDemo.deleteCourse();
		//OneToManyDemo.getCoursesOfInstructor(1);
		
		
		//OneToMany Uni-Directional
		//OneToManyDemo.oneToManyUniDirectionalDemo();
		//OneToManyDemo.oneToOneUnidirectionalGetReviews();
		OneToManyDemo.oneToOneUnidirectionalDeleteCourse();
		
		
	}

}
