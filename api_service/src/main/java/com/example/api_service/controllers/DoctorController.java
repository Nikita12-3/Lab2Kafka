package com.example.api_service.controllers;

import com.example.api_service.clients.DataServiceClient;
import com.example.api_service.dto.DoctorDTO;
import com.example.api_service.models.Doctor;
import com.example.api_service.publishers.KafkaProducerDoctor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final KafkaProducerDoctor kafkaProducerDoctor;
    private final DataServiceClient dataServiceClient;

    @GetMapping
    public ResponseEntity<List<Doctor>> findAllDoctors() {
        return dataServiceClient.findAllDoctors();
    }

    @PostMapping
    public ResponseEntity<Void> createDoctor(@RequestBody DoctorDTO doctorDto) {
        if (kafkaProducerDoctor.sendMessageDoctor(doctorDto)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
