package com.ust.Volunteer_Service.Service;

import com.ust.Volunteer_Service.Model.Volunteer;
import com.ust.Volunteer_Service.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteersRepo;
    public Volunteer saveVolunteer(Volunteer volunteer) {
        return volunteersRepo.save(volunteer);
    }

    public List<Volunteer> getNearbyVolunteers(String latitude, String longitude) {
        // Implement logic to filter volunteers based on location
        return volunteersRepo.findByLatitudeAndLongitude(latitude, longitude);
    }
  public List<Volunteer> getAllVolunteers(){
    return volunteersRepo.findAll();
   }
}
