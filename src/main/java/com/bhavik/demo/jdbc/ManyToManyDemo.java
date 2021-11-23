package com.bhavik.demo.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavik.demo.entity.Course;
import com.bhavik.demo.entity.Instructor;
import com.bhavik.demo.entity.InstructorDetail;
import com.bhavik.demo.entity.Review;
import com.bhavik.demo.entity.Student;

public class ManyToManyDemo {

	public static void storeNewObjects() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			Course course1 = new Course("JAVA Course");
			session.save(course1);

			Course tempCourse = session.get(Course.class, 2);

			Student s1 = new Student("Bhavik", "Vashi");
			Student s2 = new Student("Raj", "Patel");
			tempCourse.addStudent(s1);
			tempCourse.addStudent(s2);

			session.save(s1);
			session.save(s2);

			session.getTransaction().commit();

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
