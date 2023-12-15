package com.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	//1.Create SessionFactory 
    	SessionFactory factory = new Configuration().
    			configure("hibernate.cfg.xml").
    			addAnnotatedClass(Student.class).
    			buildSessionFactory();
    	//2.create Session
    	Session session = factory.openSession();
    	//3.begin the transaction
    	session.beginTransaction();
    	
    	//4. Perform Operations
    	//create Student Object
    	Student s = new Student();
    	s.setFirstName("Sammed");
    	s.setLastName("Akiwate");
    	s.setAge(28);
    	session.save(s);
    	
    	//Get Student - id
		/*
		 * int id = 5; 
		 * Student s = session.get(Student.class, id);
		 * System.out.println(s);
		 */
    	
    	//Update Student
		/*
		 * int id= 3; Student s = session.get(Student.class,id);
		 * s.setFirstName("Manasi"); s.setLastName("Rajput");
		 */
    	
    	//delete Student
		
//		  int id= 2; 
//		  Student s = session.get(Student.class,id);
//		   session.delete(s);
		 
    	
    	//list of Students
		/*
		 * Query query= session.createQuery("from Student");
		 *  List<Student> l = query.list(); 
		 *  for(Student s:l) { System.out.println(s); }
		 */
    	
    	//HQl - Hibernate Query Language
		/*
		 * @SuppressWarnings("unchecked") List<Student> l =
		 * session.createQuery("from Student s where s.lastName='patel'")
		 * .getResultList(); for(Student s:l) { System.out.println(s); }
		 */
    	
    	System.out.println("Object Persisted!!!");
    	session.getTransaction().commit();
    	session.close();
    	factory.close();  	
    }
}
