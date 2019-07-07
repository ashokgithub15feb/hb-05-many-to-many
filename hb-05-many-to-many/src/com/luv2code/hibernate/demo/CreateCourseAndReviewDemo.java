package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//start a transaction
			session.beginTransaction();
		
			//create a course 
			
			Course course1 = new Course("Pacman - how to score one million points");
			Course course2 = new Course("Yoga - fit amd Hit");
			
			
			//add some review
			Review review1 = new Review("Grate course... "+"loved it");
			Review review2 = new Review("Cool course... "+"job well done!!!");
			Review review3 = new Review("What a doum course... "+"loved it");
			Review review4 = new Review("Grate course... "+" you are an idiot!!!!!!!");
			
			Review review11 = new Review("Grate course... "+"loved it");
			Review review22 = new Review("Cool course... "+"job well done!!!");
			Review review33 = new Review("What a doum course... "+"loved it");
			Review review44 = new Review("Grate course... "+" you are an idiot!!!!!!!");
			
			
			course1.add(review1);
			course1.add(review2);
			course1.add(review3);
			course1.add(review4);
			
			course2.add(review11);
			course2.add(review22);
			course2.add(review33);
			course2.add(review44);
			
			//save 
			System.out.println(course1);
			System.out.println(course2);
			
			session.save(course1);
		//	session.save(course2);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("--------Done!!!---------");
		}finally
		{
			System.out.println("Close factory object!!");
			session.close();
			factory.close();
		}
		
	}

}
