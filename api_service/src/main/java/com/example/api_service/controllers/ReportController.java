package com.example.api_service.controllers;

import com.example.api_service.clients.DataServiceClient;
import com.example.api_service.publishers.KafkaProducerDoctor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final KafkaProducerDoctor kafkaProducerDoctor;
    private final DataServiceClient dataServiceClient;

    @GetMapping("/by-doctor")
    public ResponseEntity<Map<String, Long>> getByDoctor() {
        return dataServiceClient.getByDoctor();
    }

    @GetMapping("/by-specialty")
    public ResponseEntity<Map<String, Long>> getBySpecialty() {
        return dataServiceClient.getBySpecialty();
    }

    @GetMapping("/by-month")
    public ResponseEntity<Map<String, Long>> getByMonth() {
        return dataServiceClient.getByMonth();
    }
}
