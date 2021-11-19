package com.bhavik.demo.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavik.demo.entity.Instructor;
import com.bhavik.demo.entity.InstructorDetail;

public class OneToOneDemo {

	public static void storeNewObject() {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			InstructorDetail instructorDetail = new InstructorDetail("IT", 4);
			Instructor instructor = new Instructor("Yash","Patel","yash@gmail.com", instructorDetail);
			session.save(instructor);
			
			
			session.getTransaction().commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	public static void readInstructorObject() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);
			System.out.println(instructorDetail);
			
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println(instructor);
			
			
			session.getTransaction().commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
