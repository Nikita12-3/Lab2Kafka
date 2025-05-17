package com.example.api_service.publishers;

import com.example.api_service.dto.AppointmentDTO;
import com.example.api_service.dto.DoctorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerDoctor {
    @Value("${kafka.doctor.topic}")
    private String doctorsTopic;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public boolean sendMessageDoctor(DoctorDTO doctorDTO) {
        try {
            String key = UUID.randomUUID().toString();
            String doctorDtoJson = objectMapper.writeValueAsString(doctorDTO);
            kafkaTemplate.send(doctorsTopic, key, doctorDtoJson);
        } catch (JsonProcessingException e) {
            log.error("Произошла JsonProcessingException1");
            return false;
        }
        return true;
    }
}
