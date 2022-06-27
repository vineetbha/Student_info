package com.nt.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student_info;

public class CreateStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student_info.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new teacher object...");
			Student_info si = new Student_info();
			si.setName("Suresh");
			si.setDapatment("B.Tech");
			si.setCountry("India");
			
			Student_info si1 = new Student_info();
			si1.setName("Muri");
			si1.setDapatment("B.Arch");
			si1.setCountry("Canada");
			
			Student_info si2 = new Student_info();
			si2.setName("Daniel");
			si2.setDapatment("B.Tech");
			si2.setCountry("New Zealand");
			
			Student_info si3 = new Student_info();
			si3.setName("Tanya");
			si3.setDapatment("B.com");
			si3.setCountry("USA");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving the Student_info ...");
			session.save(si);
			session.save(si1);
			session.save(si2);
			session.save(si3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
