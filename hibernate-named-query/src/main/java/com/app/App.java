package com.app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = 
				new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		// Hibernate Named Query
		TypedQuery<Employee> query = 
				session.getNamedQuery("findEmployeeByName");
		query.setParameter("name", "nikita");
		List<Employee> employees = query.getResultList(); 
		Iterator<Employee> itr = employees.iterator();
		while (itr.hasNext()) {
			Employee e = itr.next();
			System.out.println(e);
		}
		// session.getTransaction().commit();
		session.close();
	}
}