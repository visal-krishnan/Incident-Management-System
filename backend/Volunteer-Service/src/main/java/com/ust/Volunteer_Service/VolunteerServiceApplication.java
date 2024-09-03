package com.ust.Volunteer_Service;

import com.ust.Incident_Management_System.Model.IncidentReport;
import com.ust.Volunteer_Service.Dto.VolunteerResponse;
import com.ust.Volunteer_Service.Model.Volunteer;
import com.ust.Volunteer_Service.Model.VolunteerNotification;
import com.ust.Volunteer_Service.Service.VolunteerNotificationService;
import com.ust.Volunteer_Service.Service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class VolunteerServiceApplication {

	@Autowired
	private VolunteerService volunteerService;

	@Autowired
	private VolunteerNotificationService notificationService;


	public static void main(String[] args) {
		SpringApplication.run(VolunteerServiceApplication.class, args);
	}

	@KafkaListener(topics = "incident-topic", groupId = "notification-group")
	public void handleNotification(@Payload IncidentReport incident) {
		log.info("Recievced notification for IncidentReport is {}", incident);
		log.info("Map Link is {}", incident.getMapLink());
		volunteerService.addIncidentReport(incident);
		notificationService.addNotificationtoVolunteer(incident);

//		String incidentCity = incident.getCity();
//
//		// Retrieve all volunteers from the service
//		List<Volunteer> volunteers = volunteerService.getAllVolunteers();
//
//		// Filter volunteers by city
//		List<Volunteer> relevantVolunteers = volunteers.stream()
//				.filter(volunteer -> volunteer.getCity().equalsIgnoreCase(incidentCity))
//				.collect(Collectors.toList());
//
//		// Create notifications for relevant volunteers
//		for (Volunteer volunteer : relevantVolunteers) {
//			String message = String.format(
//					"New incident reported in your city! Type: %s. Location: %s",
//					incident.getTypeOfIncident(), incident.getMapLink());
//
//			VolunteerNotification notification = new VolunteerNotification();
//			notification.setMessage(message);
//			notification.setVolunteer(volunteer);
//			// Since we're not persisting IncidentReport, we use a DTO or plain object
//			notification.setIncidentReport(incident); // This will be a transient field
//
//			notificationService.createNotification(notification);
//		}
//	}
	}
}
