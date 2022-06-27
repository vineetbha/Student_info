package com.nt.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student_info;



public class UpdateStudent {

	private static String studentId;

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student_info.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// start a transaction
			session.beginTransaction();

			
			System.out.println("getting Student with id :" + studentId);

			//fetching record where student id = 1
			Student_info tempStudent = session.get(Student_info.class, studentId);

			//updating value using setters
			System.out.println("updating Student--");
			tempStudent.setName("Amit");
			
			//commit transaction
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update country for all student whose name is Amit
			System.out.println("update country for all student");
			session.createQuery("update student set country = 'India' where name='Amit'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
