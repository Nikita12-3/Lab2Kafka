package com.example.api_service.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
    @Value("${kafka.appointment.topic}")
    private String appointmentsTopic;
    @Value("${kafka.doctor.topic}")
    private String doctorsTopic;

    @Bean
    public NewTopic createAppointmentTopic() {
        return TopicBuilder.name(appointmentsTopic).partitions(4).build();
    }

    @Bean
    public NewTopic createDoctorTopic() {
        return TopicBuilder.name(doctorsTopic).partitions(4).build();
    }
}
