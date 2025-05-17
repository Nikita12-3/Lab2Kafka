package com.example.api_service.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentDTO {
    private LocalDateTime date;
    private String patientLastName;
    private Long doctorId;
}
