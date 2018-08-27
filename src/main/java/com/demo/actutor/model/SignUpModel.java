package com.demo.actutor.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SignUpModel {

	@NotEmpty(message = "Please provide a username")
	private String username;
	
	@Email(message = "Please provide a valid Email")
	@NotEmpty(message = "Please provide an Email")
	private String email;
	
	@NotEmpty(message = "Please provide your phone number")
	private String phone;
	
	@NotEmpty(message = "Please provide a valid password")
	private String password;
	
	@NotEmpty(message = "Please confirm the password")
	private String passwordConfirmation;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String password) {
		this.passwordConfirmation = password;
	}
	
}