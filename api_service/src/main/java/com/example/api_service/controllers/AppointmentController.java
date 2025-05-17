package com.example.api_service.controllers;

import com.example.api_service.clients.DataServiceClient;
import com.example.api_service.dto.AppointmentDTO;
import com.example.api_service.models.Appointment;
import com.example.api_service.publishers.KafkaProducerAppointment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final KafkaProducerAppointment kafkaProducerAppointment;
    private final DataServiceClient dataServiceClient;

    @GetMapping
    public ResponseEntity<List<Appointment>> findAllAppointments() {
        return dataServiceClient.findAllAppointments();
    }

    @PostMapping
    public ResponseEntity<Void> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        if (kafkaProducerAppointment.sendMessageAppointment(appointmentDTO)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
