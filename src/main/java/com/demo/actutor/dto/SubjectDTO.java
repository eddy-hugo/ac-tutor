package com.demo.actutor.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;



public class SubjectDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subject_id")
	private Long id;
	
	@Column(name = "subject_name")
	@NotEmpty(message = "Please provide the subject's name")
	private String subjectName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	} 

}
