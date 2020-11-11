package com.akhil.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.akhil.dao.EventSchedulerDao;
import com.akhil.dto.EventScheduler;
import com.akhil.model.ResponseModel;
import com.akhil.thread.EventThread;

@Service
public class EventSchedulerService {

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	@Autowired
	private EventSchedulerDao dao;

	public void sendAlertEvent() {
		List<EventScheduler> listOfScheduledEvent = dao.findAllScheduledEventTillNow(new Date());

		if (listOfScheduledEvent != null && !listOfScheduledEvent.isEmpty()) {
			for (EventScheduler eventScheduler : listOfScheduledEvent) {
				System.out.println("Alert sent to " + eventScheduler.getUsername());
				eventScheduler.setEventSentStatus(true);
				dao.save(eventScheduler);
			}
		}
	}

	public List<EventScheduler> getAllScheduledevents() {
		return dao.findAllScheduledEvent();
	}

	public ResponseModel addScheduledEvent(EventScheduler event) {
		try {
			dao.save(event);

			threadPoolTaskScheduler.schedule(new EventThread(dao, event), event.getScheduledTime());

			ResponseModel model = new ResponseModel();
			model.setResponseCode(200);
			model.setReponseMessage("Event Scheduled successfully");
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseModel model = new ResponseModel();
			model.setResponseCode(400);
			model.setReponseMessage("Event Scheduled failed due to : " + e.getMessage());
			return model;
		}
	}
}
