package com.example.api_service.models;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {
    private LocalDateTime date;
    private String patientLastName;
    private Doctor doctor;
}