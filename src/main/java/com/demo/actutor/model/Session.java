package com.demo.actutor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "session")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "session_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@OneToOne
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	
	@OneToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@Column(name = "start_date",nullable=false)
	private Date startDateTime;
	
	@Column(name = "end_date",nullable=false)
	private Date endDateTime;
	
	
	@Column(name = "session_description")
	private String sessionDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getSessionDescription() {
		return sessionDescription;
	}

	public void setSessionDescription(String sessionDescription) {
		this.sessionDescription = sessionDescription;
	}
	
	
}
