package com.hotel.MicroService_Head.entityDao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "register")
public class Register {

	@Id
	private String id;
	
	private String email;
	
	private String password;
	
	private String role;
	
	private String empId;
	
	public Register() {
		
	}

	public Register(String id, String email, String password, String role, String empId) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.empId = empId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + ", empId="
				+ empId + "]";
	}
	
}
