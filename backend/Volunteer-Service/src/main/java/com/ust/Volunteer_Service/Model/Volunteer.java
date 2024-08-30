package com.ust.Volunteer_Service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long volunteerId;
    private String contactName;
    private String phoneNumber;
    private String address;
    private String latitude;
    private String longitude;
    private String skills;
    private String photoPath;
    private String personStatus;
    private String availabilityStatus = "Available";
    private LocalDateTime registeredAt = LocalDateTime.now();

}
