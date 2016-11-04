package net.codejava.spring.model;

public class User {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String usertype;
	
	
	public User(){
		
	}
	public User(String username, String password, String firstname, String lastname,String email, String usertype) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.usertype = usertype;
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
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return usertype;
	}

	public void setUserType(String usertype) {
		this.usertype = usertype;
	}
}
