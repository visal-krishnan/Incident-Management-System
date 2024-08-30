package com.ust.Notification_service.Model;

//import com.ust.Notification_service.Feign.Emergency;
//import com.ust.Notification_service.Feign.IncidentReport;
//import com.ust.Notification_service.Feign.Volunteer;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class IncidentNotification {
    @Id
    private Long notification_id;
    private LocalDateTime sentAt=LocalDateTime.now();
    private String status;
    private String message;
//    @ManyToOne
//    @JoinColumn(name = "volunteer_id")
//    private Volunteer volunteers;
//    @ManyToOne
//    @JoinColumn(name = "service_id")
//    private Emergency emergencyService;
//    @ManyToOne
//    @JoinColumn(name = "incident_id")
//    private IncidentReport incident;

}
