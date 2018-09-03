package com.demo.actutor.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;



@Entity
@Table(name = "user")
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "user_name")
	@NotEmpty(message = "Please provide your name")
	private String name;

	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid Email")
	@NotEmpty(message = "Please provide an Email")
	private String email;

	@Column(name = "phone")
	@NotEmpty(message = "Please provide your phone number")
	private String phone;

	@Column(name = "password")
	@Length(min = 6, message = "Your password must have at least 6 characters")
	@NotEmpty(message = "Please provide a valid password")
	@Transient
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleDTO role;
	
	@OneToOne
	@JoinColumn(name = "tutor_id")
	private TutorDTO tutor;
	
	@OneToOne
	@JoinColumn(name = "student_id")
	private StudentDTO student;



	public TutorDTO getTutor() {
		return tutor;
	}

	public void setTutor(TutorDTO tutor) {
		this.tutor = tutor;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	@Override
	public String toString() {

		return "UserDTO [user_id=" + id + ", userName=" + name + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", houses=" + "]";
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

}
