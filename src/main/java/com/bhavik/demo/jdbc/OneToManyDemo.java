package com.bhavik.demo.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhavik.demo.entity.Course;
import com.bhavik.demo.entity.Instructor;
import com.bhavik.demo.entity.InstructorDetail;
import com.bhavik.demo.entity.Review;

public class OneToManyDemo {

	public static void storeNewObject() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			InstructorDetail instructorDetail = new InstructorDetail("IT", 4);
			Instructor instructor = new Instructor("Yash", "Patel", "yash@gmail.com", instructorDetail);
			session.save(instructor);

			session.getTransaction().commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void getCoursesOfInstructor(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Instructor : " + instructor);

			System.out.println("Instructor Courses: " + instructor.getCourseList());

			session.getTransaction().commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void addNewCourse(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, id);

			Course course1 = new Course("Python OOPs");
			instructor.addCourse(course1);

			session.save(course1);
			session.save(instructor);
			session.getTransaction().commit();

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public static void deleteCourse() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			Course courseTemp = session.get(Course.class, 1);
			session.delete(courseTemp);

			session.getTransaction().commit();

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public static void oneToManyUniDirectionalDemo() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			Course course1 = new Course("Apple Silicon");

			Review review1 = new Review("Reivew Note");
			session.save(review1);

			course1.addReview(review1);
			session.save(course1);

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
