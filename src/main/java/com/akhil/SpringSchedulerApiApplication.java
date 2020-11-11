package com.akhil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.akhil.dao.EventSchedulerDao;
import com.akhil.dto.EventScheduler;
import com.akhil.service.EventSchedulerService;
import com.akhil.thread.EventThread;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class SpringSchedulerApiApplication implements CommandLineRunner {

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	@Autowired
	private EventSchedulerService service;

	@Autowired
	private EventSchedulerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Executing missing events");
		service.sendAlertEvent();

		List<EventScheduler> scheduledevents = service.getAllScheduledevents();

		for (EventScheduler event : scheduledevents) {
			threadPoolTaskScheduler.schedule(new EventThread(dao, event), event.getScheduledTime());
		}

	}

}
