package com.ust.Incident_Management_System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Incident")
public class IncidentReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
   // private LocalDateTime reportedAt=LocalDateTime.now();


}
