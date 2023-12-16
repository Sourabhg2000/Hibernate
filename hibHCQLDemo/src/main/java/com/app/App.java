package com.app;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		/*
		 * //save Student s = new Student(); s.setFirstName("Rahul");
		 * s.setLastName("Pawar"); s.setFees(25000); session.save(s);
		 */

		/*
		 * Criteria c = session.createCriteria(Student.class); List<Student> l
		 * =c.list(); for (Student s : l) { System.out.println(s); }
		 */

		/*
		 * Criteria c = session.createCriteria(Student.class); c.setFirstResult(1);
		 * c.setMaxResults(2); List<Student> l = c.list(); for (Student s : l) {
		 * System.out.println(s); }
		 */

		/*Criteria c = session.createCriteria(Student.class);
		c.add(Restrictions.le("fees", 5000.00));
		List<Student> l = c.list();
		for (Student s : l) {
			System.out.println(s);
		}*/

		
		  Criteria c = session.createCriteria(Student.class);
		  c.addOrder(Order.desc("firstName")); 
		  List<Student> l = c.list(); 
		  for(Student s : l)
		  { 
			  System.out.println(s); 
		   }
		 

		session.getTransaction().commit();
		System.out.println("Success");
		session.close();

	}
}
