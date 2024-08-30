package com.ust.Notification_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

//	@KafkaListener(topics = "incident-topic", groupId = "notification-group")
//	public void listen(IncidentReport incidentReport) {
//		System.out.println("Received IncidentReport: " + incidentReport);
//		}
	@KafkaListener(topics = "incident-topic", groupId = "notification-group")
	public void handleNotification(IncidentReport incident){
		log.info("Recievced notification for IncidentReport is {}", incident);
	}

}
