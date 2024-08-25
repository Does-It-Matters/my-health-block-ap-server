package com.example.myhealthblock.config.output.adapter;

import com.example.myhealthblock.doctor.adapter.out.mybatis.DoctorMapper;
import com.example.myhealthblock.doctor.adapter.out.mybatis.DoctorPersistenceAdapter;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("jpa")
public class JpaConfig {
    @Bean
    public DoctorOutputPort doctorOutputPort(DoctorMapper doctorMapper) {
        return new DoctorPersistenceAdapter(doctorMapper);
    }
}