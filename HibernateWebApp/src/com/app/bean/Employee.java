package com.app.bean;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="emp456")
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="empName")
	private String name;
	@Column(name="empPassword")
	private String password;
	@Column(name="empEmail")
	private String email;
	
	public Employee() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
