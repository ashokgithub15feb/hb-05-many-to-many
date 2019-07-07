package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
		
			//create a course 
			
			Course course1 = new Course("Pacman - how to score one million points");

			//save the course
			
			session.save(course1);
			
			System.out.println("Saved: "+course1);
			
			//create student
			Student student1 = new Student("John", "Doe", "john@luv2code.com");
			Student student2 = new Student("mary", "public", "mary@luv2code.com");
			
			course1.addStudent(student1);
			course1.addStudent(student2);
			
			System.out.println("saving student: ");
			
			session.save(student1);
			session.save(student2);
			System.out.println("saved student: "+course1.getStudents());
			
			
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
