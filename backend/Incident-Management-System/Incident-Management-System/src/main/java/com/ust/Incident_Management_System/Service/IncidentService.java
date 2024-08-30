package com.ust.Incident_Management_System.Service;

import com.ust.Incident_Management_System.Model.IncidentReport;
import com.ust.Incident_Management_System.Repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepo;
    @Autowired
    private KafkaTemplate<String, IncidentReport> kafkaTemplate;
    private static final String TOPIC = "incident-topic";

    public IncidentReport addIncident(IncidentReport incident) {
        IncidentReport savedReport = incidentRepo.save(incident);
        kafkaTemplate.send(TOPIC, savedReport);
        return savedReport;
    }

    public IncidentReport getIncidentById(Long incidentId) {
        return incidentRepo.findById(incidentId).orElse(null);
    }

    public List<IncidentReport> getAllIncidents() {
        return incidentRepo.findAll();
    }


    public List<IncidentReport> getIncidentsByType(String typeOfPerson) {
        return incidentRepo.findByTypeOfPerson(typeOfPerson);
    }

    public List<IncidentReport> getIncidentsBySeverity(String severity) {
        return incidentRepo.findBySeverity(severity);
    }

    public List<IncidentReport> getIncidentsByStatus(String status) {
        return incidentRepo.findByStatus(status);
    }

    public List<IncidentReport> getIncidentsByTypeOfIncident(String typeOfIncident) {
        return incidentRepo.findByTypeOfIncident(typeOfIncident);
    }

    public List<IncidentReport> getIncidentsByLatitudeAndLongitude(String lat, String lng) {
        return incidentRepo.findByLatitudeAndLongitude(lat, lng);
    }

    public List<IncidentReport> getIncidentsByTypeofIncidentAndSeverity(String typeOfIncident, String severity) {
        return incidentRepo.findByTypeOfIncidentAndSeverity(typeOfIncident, severity);
    }


    @Transactional
    public void reportIncident(IncidentReport incidentReportDetails) {
        // Create and save incident report to the database

        incidentRepo.save(incidentReportDetails);

        // Send incident report to the Kafka topic
        kafkaTemplate.send(TOPIC, incidentReportDetails);
    }
}
