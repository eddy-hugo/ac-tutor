package com.demo.actutor.dto;

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
public class SessionDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "session_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "student_id")
	private StudentDTO student;
	
	@OneToOne
	@JoinColumn(name = "tutor_id")
	private TutorDTO tutor;
	
	@OneToOne
	@JoinColumn(name = "subject_id")
	private SubjectDTO subject;
	
	@OneToOne
	@JoinColumn(name = "datetime_id")
	private DatetimeDTO datetime;
	
	@Column(name = "session_description")
	private String sessionDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public TutorDTO getTutor() {
		return tutor;
	}

	public void setTutor(TutorDTO tutor) {
		this.tutor = tutor;
	}

	public SubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	public DatetimeDTO getDatetime() {
		return datetime;
	}

	public void setDatetime(DatetimeDTO datetime) {
		this.datetime = datetime;
	}

	public String getSessionDescription() {
		return sessionDescription;
	}

	public void setSessionDescription(String sessionDescription) {
		this.sessionDescription = sessionDescription;
	}
	
	
}
