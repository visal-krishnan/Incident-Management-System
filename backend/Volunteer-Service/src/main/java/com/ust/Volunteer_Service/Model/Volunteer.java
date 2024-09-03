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
    private String address;
    private String state;
    private String city;
    private Long age;
    private String gender;

    private String phoneNumber;
    private String email;
    private String password;
    private String skills;
    private String photoPath;
//    private String personStatus;


    @Enumerated(EnumType.STRING)
    private VolunteerAvailability availabilityStatus ;
    private LocalDateTime registeredAt = LocalDateTime.now();

}
