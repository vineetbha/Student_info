package com.nt.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student_info;


public class DisplayStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student_info.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query student
			List<Student_info> theStudent = session.createQuery("from Student_info").list();

			// display student
			displayStudent(theStudent);

			// query student name = 'Amit'
			System.out.println("Student with lastName Binny");
			theStudent = session.createQuery("from Student s where s.name='Amit'").list();


			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student_info> theStudent) {
		// TODO Auto-generated method stub
		
	}

	//display Student method uses enhanced for loop
	private static void displayTeachers(List<Student_info> theStudent) {
		for (Student_info tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}
}
