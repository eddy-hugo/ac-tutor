package com.demo.actutor.dto;

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
public class TutorDTO {
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
	@JoinTable(name = "tutor_subjects", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "subject_id") })
	private Set<SubjectDTO> subjects;
	
	
}
