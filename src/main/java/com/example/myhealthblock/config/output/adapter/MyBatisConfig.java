package com.example.myhealthblock.config.output.adapter;

import com.example.myhealthblock.doctor.adapter.out.jpa.DoctorPersistenceAdapter;
import com.example.myhealthblock.doctor.adapter.out.jpa.DoctorRepository;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mongo")
public class MyBatisConfig {
    @Bean
    public DoctorOutputPort doctorOutputPort(DoctorRepository doctorRepository) {
        return new DoctorPersistenceAdapter(doctorRepository);
    }
}