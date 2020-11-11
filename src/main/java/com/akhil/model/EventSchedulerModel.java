package com.akhil.model;

public class EventSchedulerModel {

	private String scheduledTime;

	private String username;

	private Boolean eventSentStatus = false;

	@Override
	public String toString() {
		return "EventSchedulerModel [scheduledTime=" + scheduledTime + ", username=" + username + ", eventSentStatus="
				+ eventSentStatus + "]";
	}

	public String getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(String scheduledTime) {
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
