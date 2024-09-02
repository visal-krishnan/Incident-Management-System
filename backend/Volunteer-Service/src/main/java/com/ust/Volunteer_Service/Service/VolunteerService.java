package com.ust.Volunteer_Service.Service;

import com.ust.Incident_Management_System.Model.IncidentReport;
import com.ust.Volunteer_Service.Model.Volunteer;
import com.ust.Volunteer_Service.Repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class VolunteerService {
    private final List<IncidentReport> incidentReports = new ArrayList<>();

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

    public synchronized void addIncidentReport(IncidentReport report) {
        incidentReports.add(report);
    }
    public synchronized List<IncidentReport> getAllIncidentReports() {
        return new ArrayList<>(incidentReports);
    }




}
