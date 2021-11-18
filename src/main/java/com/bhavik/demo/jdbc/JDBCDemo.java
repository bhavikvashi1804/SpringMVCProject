package com.bhavik.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {

	public void fetchDetailsFromDB() {

		String dbURL = "jdbc:mysql://localhost:3306/student_tracker?useSSL=false";
		String username = "student";
		String password = "Student@123";

		try {
			System.out.println("Connection to Database: "+ dbURL);
			
			Connection myConn = DriverManager.getConnection(dbURL, username, password);
			
			System.out.println("Connection Successful!!!");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
