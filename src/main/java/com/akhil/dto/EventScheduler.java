package com.akhil.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EventScheduler")
public class EventScheduler {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "scheduled_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduledTime;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "status")
	private Boolean eventSentStatus = false;

	@Override
	public String toString() {
		return "EventScheduler [id=" + id + ", scheduledTime=" + scheduledTime + ", username=" + username
				+ ", eventSentStatus=" + eventSentStatus + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEventSentStatus() {
		return eventSentStatus;
	}

	public void setEventSentStatus(Boolean eventSentStatus) {
		this.eventSentStatus = eventSentStatus;
	}

}
