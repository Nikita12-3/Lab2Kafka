package com.example.api_service.clients;

import com.example.api_service.models.Appointment;
import com.example.api_service.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class DataServiceClient implements DataServiceClientI {

    @Value("${data-service.base-url}")
    private String dataServiceBaseUrl;

    @Value("${data-service.port}")
    private String dataServicePort;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseEntity<Map<String, Long>> getByDoctor() {
        String url = String.format("%s:%s/api/reports/by-doctor", dataServiceBaseUrl, dataServicePort);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Long>>() {}
        );
    }

    @Override
    public ResponseEntity<Map<String, Long>> getBySpecialty() {
        String url = String.format("%s:%s/api/reports/by-specialty", dataServiceBaseUrl, dataServicePort);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Long>>() {}
        );
    }

    @Override
    public ResponseEntity<Map<String, Long>> getByMonth() {
        String url = String.format("%s:%s/api/reports/by-month", dataServiceBaseUrl, dataServicePort);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Long>>() {}
        );
    }

    @Override
    public ResponseEntity<List<Doctor>> findAllDoctors() {
        String url = String.format("%s:%s/api/doctors", dataServiceBaseUrl, dataServicePort);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Doctor>>() {}
        );
    }

    @Override
    public ResponseEntity<List<Appointment>> findAllAppointments() {
        String url = String.format("%s:%s/api/appointments", dataServiceBaseUrl, dataServicePort);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Appointment>>() {}
        );
    }
}
