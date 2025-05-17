package com.example.data_service.services;

import com.example.data_service.dto.AppointmentDTO;
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
public class AppointmentService {
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    public Optional<Appointment> addAppointment(AppointmentDTO appointmentDTO) {
        Optional<Doctor> doctor = doctorRepository.findById(appointmentDTO.getDoctorId());

        if (doctor.isEmpty()) {
            log.error("Doctor not found with ID: {}", appointmentDTO.getDoctorId());
            return Optional.empty();
        }

        Appointment appointment = new Appointment();
        appointment.setDate(appointmentDTO.getDate());
        appointment.setPatientLastName(appointmentDTO.getPatientLastName());
        appointment.setDoctor(doctor.get());

        Appointment savedAppointment = appointmentRepository.save(appointment);
        log.info("Created appointment with ID: {}", savedAppointment.getId());

        return Optional.of(savedAppointment);
    }

}