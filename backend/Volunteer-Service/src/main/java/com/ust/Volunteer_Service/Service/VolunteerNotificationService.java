package com.ust.Volunteer_Service.Service;

import com.ust.Incident_Management_System.Model.IncidentReport;
import com.ust.Volunteer_Service.Dto.VolunteerNotificationResponse;
import com.ust.Volunteer_Service.Model.Volunteer;
import com.ust.Volunteer_Service.Model.VolunteerNotification;
import com.ust.Volunteer_Service.Repository.VolunteerNotificationRepository;
import com.ust.Volunteer_Service.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerNotificationService {

    @Autowired
    private VolunteerNotificationRepository notificationRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

//    public List<VolunteerNotificationResponse> getNotificationsForVolunteer(Long volunteerId) {
//        Volunteer volunteer = volunteerRepository.findById(volunteerId)
//                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
//
//        String volunteerCity = volunteer.getVolunteerCity();
//
//        // Fetch notifications for this volunteer
//        List<VolunteerNotification> notifications = notificationRepository.findByVolunteer_VolunteerId(volunteerId);
//
//    }

    public void addNotificationtoVolunteer(IncidentReport incident) {
        String city = incident.getCity();
        List<Volunteer> volunteersInCity = volunteerRepository.findByVolunteerCity(city);
        for (Volunteer volunteer : volunteersInCity) {
            VolunteerNotification notification = new VolunteerNotification();
            notification.setMessage(createNotificationMessage(incident));
            notification.setVolunteer(volunteer);
            notification.setCreatedAt(LocalDateTime.now());
            // If you have an IncidentReport DTO or related information, set it if necessary
            notification.setIncidentReport(incident);

            // Save the notification to the database
            notificationRepository.save(notification);
        }

    }

    private String createNotificationMessage(IncidentReport incident) {
        // Customize the message format as needed
        return String.format("Incident Reported: %s. at Location: %s. Description: %s. City: %s. Please find the map link below:%s.",
                incident.getTypeOfIncident(), incident.getLocation(), incident.getDescription(), incident.getCity(),  incident.getMapLink());
    }

    public List<VolunteerNotificationResponse> getNotificationsForVolunteer(Long volunteerId) {
        List<VolunteerNotification> notifications =  notificationRepository.findByVolunteer_VolunteerId(volunteerId);

        // Convert List<VolunteerNotification> to List<VolunteerNotificationResponse>
        return notifications.stream()
                .map(notification -> {
                    VolunteerNotificationResponse response = new VolunteerNotificationResponse();
                    response.setMessage(notification.getMessage());
                    if (notification.getIncidentReport() != null) {
                        response.setMapLink(notification.getIncidentReport().getMapLink());
                    } else {
                        response.setMapLink(null);
                    }
                    return response;
                })
                .collect(Collectors.toList());
    }
}

