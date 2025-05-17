package com.example.api_service.clients;

import com.example.api_service.models.Appointment;
import com.example.api_service.models.Doctor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DataServiceClientI {
    ResponseEntity<Map<String, Long>> getByDoctor();
    ResponseEntity<Map<String, Long>> getBySpecialty();
    ResponseEntity<Map<String, Long>> getByMonth();
    ResponseEntity<List<Doctor>> findAllDoctors();
    ResponseEntity<List<Appointment>> findAllAppointments();
}
