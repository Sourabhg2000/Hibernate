package com.app.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.entity.Instructor;
import com.app.entity.InstructorDetail;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = 
        		new Configuration().configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Instructor.class)
        		.addAnnotatedClass(InstructorDetail.class)
        		.buildSessionFactory();
        Session session = factory.openSession();
        
        Instructor instructor = 
        		new Instructor("aishwarya","patil","patil@gmail.com");
        InstructorDetail  instructorDetail =    
        new InstructorDetail("http://www.mno.com/youtube","Singing");
        
        //associate the objects
        instructor.setInstructorDetail(instructorDetail);
        
        session.beginTransaction();
        
       session.save(instructor);
     
       session.getTransaction().commit();
       session.close();

    }
}
