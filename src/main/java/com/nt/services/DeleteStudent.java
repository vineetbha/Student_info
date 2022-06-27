package com.nt.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student_info;


public class DeleteStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student_info.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 4;

			// start a transaction
			session.beginTransaction();

			System.out.println("getting teacher with id :" + studentId);

			// fetching record where student id = 4
			Student_info tempStudent = session.get(Student_info.class, studentId);

			// deleting value using session.delete method
			System.out.println("delete teacher--");
			session.delete(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			// delete student with id = 4 using createQuery
			System.out.println("delete Student with id = 4");
			session.createQuery("delete from Student where id = 4").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
