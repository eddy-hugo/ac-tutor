package com.demo.actutor.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datetime")
public class DatetimeDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "datetime_id")
	private Long id;
	
	
	@Column(name = "start_datetime")
	private Date startDateTime;
	
	@Column(name = "end_datetime")
	private Date endDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	
	
	
}
