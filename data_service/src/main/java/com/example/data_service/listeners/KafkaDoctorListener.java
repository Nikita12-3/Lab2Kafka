package com.example.data_service.listeners;

import com.example.data_service.dto.AppointmentDTO;
import com.example.data_service.dto.DoctorDTO;
import com.example.data_service.models.Appointment;
import com.example.data_service.models.Doctor;
import com.example.data_service.services.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaDoctorListener {
    private final DoctorService doctorService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "doctor-topic", groupId = "data-service")
    public void processDoctor(String doctorJson) {
        try {
            DoctorDTO doctorDTO = objectMapper.readValue(doctorJson, DoctorDTO.class);
            Optional<Doctor> doctorOptional = doctorService.addDoctor(doctorDTO);
            if (doctorOptional.isPresent()) {
                System.out.println(doctorOptional.get());
            } else {
                log.info("Запись не создана. Ошибка в данных DTO");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
