package com.app.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.app.entity.Instructor;
import com.app.entity.InstructorDetail;
public class DeleteDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Instructor.class)
        		.addAnnotatedClass(InstructorDetail.class)
        		.buildSessionFactory();
        Session session = factory.openSession();
        
        try
        {
        session.beginTransaction();
        
        int theId = 1;
        Instructor tempInstructor = session.get(Instructor.class, theId);
        
        System.out.println("Found Instructor: "+tempInstructor);
        
        //delete the Instructor
        if(tempInstructor!=null)
        {
        	System.out.println("Deleteing...."+tempInstructor);
        	session.delete(tempInstructor);
        }
        
        session.getTransaction().commit();
        System.out.println("Success");
        
        }finally {
			session.close();
			factory.close();
		}
        
		
	}

}
