package com.ust.Volunteer_Service;

import com.ust.Incident_Management_System.Model.IncidentReport;
import com.ust.Volunteer_Service.Service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@Slf4j
public class VolunteerServiceApplication {

	@Autowired
	private VolunteerService volunteerService;


	public static void main(String[] args) {
		SpringApplication.run(VolunteerServiceApplication.class, args);
	}

	@KafkaListener(topics = "incident-topic", groupId = "notification-group" )
	public void handleNotification(@Payload IncidentReport incident){
		log.info("Recievced notification for IncidentReport is {}", incident);
		volunteerService.addIncidentReport(incident);
	}
}
