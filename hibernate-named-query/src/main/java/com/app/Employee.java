package com.app;

import javax.persistence.*;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
 
@NamedQueries(  
    {  
        @NamedQuery(  
        name = "findEmployeeByName",  
        query = "from Employee e where e.name = :name"  
        ) ,
        
       /* @NamedQuery(
        		name="",
        		query=""
        		) */
    }  
)  
@Entity  
@Table(name="emp123")  
public class Employee {   
    
	int id;  
    String name;  
    int salary;  
    String job;
 
    public Employee() {}
    
    public Employee( String name, int salary, String job) {
		super();
		//this.id = id;
		this.name = name;
		this.salary = salary;
		this.job = job;
	}
	
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    //getters and setters  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}  
	
	
	  public String toString(){return id+" "+name+" "+salary+" "+job;}  
   
}  