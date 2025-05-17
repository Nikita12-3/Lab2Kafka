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
public class KafkaProducerAppointment {
    @Value("${kafka.appointment.topic}")
    private String appointmentsTopic;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public boolean sendMessageAppointment(AppointmentDTO appointmentDTO) {
        try {
            String key = UUID.randomUUID().toString();
            String appointmentDTOJson = objectMapper.writeValueAsString(appointmentDTO);
            kafkaTemplate.send(appointmentsTopic, key, appointmentDTOJson);
        } catch (JsonProcessingException e) {
            log.error("Произошла JsonProcessingException2");
            return false;
        }
        return true;
    }
}
