package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.bean.Employee;

public class EmployeeDAO {
	public static int registerEmp(Employee e)
	{
		SessionFactory factory = null;
		Session session = null;
		int i=0;
		try
		{
		 factory = 
				new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class).
				buildSessionFactory();
		 session = factory.openSession();
		session.beginTransaction();
		i = (int)session.save(e);
		session.getTransaction().commit();
		
		return i;
		
		}
		finally {
		session.close();
		factory.close();
		}
		
	}

	/*
	 * public static boolean loginEmployee(String uname,String pwd) public static
	 * boolean loginEmployee(Employee emp)
	 */
	
	
	
}
