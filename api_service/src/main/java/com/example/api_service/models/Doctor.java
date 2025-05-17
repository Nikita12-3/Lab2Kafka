package com.example.api_service.models;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
}