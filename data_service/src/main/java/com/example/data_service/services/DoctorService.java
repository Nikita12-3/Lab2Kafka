package com.example.data_service.services;

import com.example.data_service.dto.AppointmentDTO;
import com.example.data_service.dto.DoctorDTO;
import com.example.data_service.models.Appointment;
import com.example.data_service.models.Doctor;
import com.example.data_service.repositories.AppointmentRepository;
import com.example.data_service.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Optional<Doctor> addDoctor(DoctorDTO doctorDTO) {

        Doctor doctor = new Doctor();
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setSpecialty(doctorDTO.getSpecialty());
        doctor.setLastName(doctorDTO.getLastName());

        Doctor savedDoctor = doctorRepository.save(doctor);
        log.info("Created doctor with ID: {}", savedDoctor.getId());

        return Optional.of(savedDoctor);
    }
}
