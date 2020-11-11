package com.akhil.thread;

import java.util.Date;

import com.akhil.dao.EventSchedulerDao;
import com.akhil.dto.EventScheduler;

public class EventThread implements Runnable {

	private EventSchedulerDao dao;
	private EventScheduler event;

	public EventThread(EventSchedulerDao dao, EventScheduler event) {
		this.dao = dao;
		this.event = event;
	}

	@Override
	public void run() {
		System.out.println("Scheduled Alert sent to : " + event.getUsername() + " at : " + new Date());
		event.setEventSentStatus(true);
		dao.save(event);
	}

}
