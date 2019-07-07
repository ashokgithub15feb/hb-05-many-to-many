package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//start a transaction
			session.beginTransaction();

			//get the mary student
			
			int theId = 1;
			Student student = session.get(Student.class, theId);
			
			System.out.println("loaded syudent: "+student);
			
			System.out.println("get course: "+student.getCourses());

			
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
