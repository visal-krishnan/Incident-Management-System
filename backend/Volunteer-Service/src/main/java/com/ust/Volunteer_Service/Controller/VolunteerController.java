package com.ust.Volunteer_Service.Controller;

import com.ust.Incident_Management_System.Model.IncidentReport;
import com.ust.Volunteer_Service.Model.Volunteer;
import com.ust.Volunteer_Service.Service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/volunteers")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @PostMapping("/postvolunteer")
    public ResponseEntity<Volunteer>addVolunteer(@RequestBody Volunteer volunteer){
        return ResponseEntity.ok(volunteerService.saveVolunteer(volunteer));
    }

    @GetMapping("/getAllVolunteers")
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        return ResponseEntity.ok(volunteerService.getAllVolunteers());
    }

//    @GetMapping("/getincidentreports")
//    public ResponseEntity<List<IncidentReport>> getIncidentReports() {
//
//        return ResponseEntity.ok(volunteerService.getIncidentReports());
//
//    }

    @GetMapping("/allincidentreports")
    public List<IncidentReport> getAllIncidentReports() {
        return volunteerService.getAllIncidentReports();
    }



}
