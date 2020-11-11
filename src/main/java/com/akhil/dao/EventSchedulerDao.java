package com.akhil.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akhil.dto.EventScheduler;

@Repository
@Transactional
public interface EventSchedulerDao extends JpaRepository<EventScheduler, Integer> {

	@Query("FROM EventScheduler WHERE status=false")
	List<EventScheduler> findAllScheduledEvent();

	@Query("FROM EventScheduler WHERE scheduled_time <= ?1 and status=false")
	List<EventScheduler> findAllScheduledEventTillNow(Date scheduledTime);

}
