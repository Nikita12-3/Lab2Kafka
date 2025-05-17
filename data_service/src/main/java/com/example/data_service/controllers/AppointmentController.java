package com.example.data_service.controllers;

import com.example.data_service.models.Appointment;
import com.example.data_service.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/search")
    public List<Appointment> searchByPatientLastName(@RequestParam String lastName) {
        return appointmentRepository.findByPatientLastName(lastName);
    }
}