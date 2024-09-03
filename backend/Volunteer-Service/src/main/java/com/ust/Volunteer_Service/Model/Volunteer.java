package com.ust.Volunteer_Service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
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
    private String address;
    private String state;
    private String volunteerCity;
    private Long age;
    private String gender;

    private String phoneNumber;
    private String email;
    private String password;
    private String skills;
    private String photoPath;
//    private String personStatus;


    @Enumerated(EnumType.STRING)
    private VolunteerAvailability availabilityStatus = VolunteerAvailability.AVAILABLE ;
    private LocalDateTime registeredAt = LocalDateTime.now();

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VolunteerNotification> notifications;


}
