package com.example.data_service.controllers;

import com.example.data_service.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final AppointmentRepository appointmentRepository;
    // Существующий отчет
    @GetMapping("/by-doctor")
    public Map<String, Long> getAppointmentsByDoctor() {
        return appointmentRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        a -> a.getDoctor().getLastName(),
                        Collectors.counting()
                ));
    }

    //Распределение по специальностям
    @GetMapping("/by-specialty")
    public Map<String, Long> getAppointmentsBySpecialty() {
        return appointmentRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        a -> a.getDoctor().getSpecialty(),
                        Collectors.counting()
                ));
    }

    //Динамика записей по месяцам
    @GetMapping("/by-month")
    public Map<String, Long> getAppointmentsByMonth() {
        return appointmentRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        a -> a.getDate().getMonth().toString(),
                        Collectors.counting()
                ));
    }
}