package com.example.api_service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DoctorDTO {
    private String firstName;
    private String lastName;
    private String specialty;
}
