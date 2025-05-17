package com.example.data_service.listeners;

import com.example.data_service.dto.AppointmentDTO;
import com.example.data_service.models.Appointment;
import com.example.data_service.services.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaAppointmentListener {
    private final AppointmentService appointmentService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "appointment-topic", groupId = "data-service")
    public void processAppointment(String appointmentJson) {
        try {
            AppointmentDTO appointmentDTO = objectMapper.readValue(appointmentJson, AppointmentDTO.class);
            Optional<Appointment> appointmentOptional = appointmentService.addAppointment(appointmentDTO);
            if (appointmentOptional.isPresent()) {
                System.out.println(appointmentOptional.get());
            } else {
                log.info("Запись не создана. Ошибка в данных DTO");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
