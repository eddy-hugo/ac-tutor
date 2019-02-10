package com.demo.actutor.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "tutor")
public class Tutor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tutor_id")
	private Long id;
	
	@Column(name = "user_name")
	@NotEmpty(message = "Please provide your first name")
    private String username;
	
	@Column(name = "first_name")
	@NotEmpty(message = "Please provide your first name")
    private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Please provide your last name")
    private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid Email")
	@NotEmpty(message = "Please provide an Email")
    private String email;
	
	@Column(name = "phone")
	@NotEmpty(message = "Please provide your phone number")
    private String phone;
	
	@ManyToMany
	@JoinTable(name = "tutor_subjects", joinColumns = { @JoinColumn(name = "tutor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "subject_id") })
	private Set<Subject> subjects;
	
	@ManyToMany
	@JoinTable(name = "sessions", joinColumns = { @JoinColumn(name = "tutor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "session_id") })
	private Set<Session> sessions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	
	
}
