package com.iman;
import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String degree;
	private Date dateOfBirth;
	
	public User(String firstName, String lastName, String username,
			String password, String degree, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.degree = degree;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User){
			User user = (User) obj;
			if(!user.getUsername().equals(getUsername())){
				return true;
			}
		}
		return false;
	}
	
}
