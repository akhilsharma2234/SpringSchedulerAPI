package com.akhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.dto.EventScheduler;
import com.akhil.model.EventSchedulerModel;
import com.akhil.model.ResponseModel;
import com.akhil.service.EventSchedulerService;
import com.akhil.util.Utility;
import com.google.gson.Gson;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventSchedulerService service;

	@Autowired
	private Gson gson;

	@GetMapping({ "/", "" })
	@ResponseBody
	public String getScheduledEvents() {

		List<EventScheduler> allScheduledevents = service.getAllScheduledevents();

		if (allScheduledevents == null || allScheduledevents.isEmpty()) {
			return "No Scheduled Event";
		}

		return gson.toJson(allScheduledevents);
	}

	@PostMapping({ "/", "" })
	@ResponseBody
	public ResponseModel addScheduledEvents(@RequestBody EventSchedulerModel event) {

		System.out.println("Going to schedule an event : " + event);

		EventScheduler model = new EventScheduler();
		model.setEventSentStatus(event.getEventSentStatus());
		model.setScheduledTime(Utility.getCurrentDate(event.getScheduledTime()));
		model.setUsername(event.getUsername());

		return service.addScheduledEvent(model);
	}

}
