package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String args[]) {
		//Create SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//create a student object
			System.out.println("Creating new Student");
			Student tempStudent = new Student("Diya Reddy", "Minnam", "diyaminnam@gmail.com");
			
			// start a transaction
			session.beginTransaction();
						
		    // save the student object
		    System.out.println("Saving the student...");
			session.save(tempStudent);
						
			// commit transaction
			session.getTransaction().commit();
						
			System.out.println("Done!");			
			
		     }
		
		finally {
			factory.close();
		}
	}
	
	
	
	
	
}
