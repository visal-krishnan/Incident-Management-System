package com.ust.Notification_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentReport {

    private Long incidentId;
    private String typeOfPerson;
    private String contact_name;
    private String description;
    private String typeOfIncident;
    private String latitude;
    private String longitude;
    private String severity;
    private String status;
    private String photoPath;
   // private LocalDateTime reportedAt;


}

