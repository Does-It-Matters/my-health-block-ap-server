package com.example.myhealthblock.config.output.adapter;

import com.example.myhealthblock.doctor.adapter.out.database.jpa.DoctorPersistenceAdapter;
import com.example.myhealthblock.doctor.adapter.out.database.jpa.DoctorRepository;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutputPort;
import com.example.myhealthblock.opinion.adapter.out.database.jpa.OpinionPersistenceAdapter;
import com.example.myhealthblock.opinion.adapter.out.database.jpa.OpinionRepository;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.patient.adapter.out.database.jpa.PatientPersistenceAdapter;
import com.example.myhealthblock.patient.adapter.out.database.jpa.PatientRepository;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import com.example.myhealthblock.question.adapter.out.database.jpa.bodypart.BodyMappingRepository;
import com.example.myhealthblock.question.adapter.out.database.jpa.personaldata.PersonalDataRepository;
import com.example.myhealthblock.question.adapter.out.database.jpa.question.QuestionPersistenceAdapter;
import com.example.myhealthblock.question.adapter.out.database.jpa.question.QuestionRepository;
import com.example.myhealthblock.question.application.port.out.QuestionOutputPort;
import com.example.myhealthblock.user.adapter.out.database.jpa.UserPersistenceAdapter;
import com.example.myhealthblock.user.adapter.out.database.jpa.UserRepository;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;

import com.example.myhealthblock.doctor.adapter.out.jpa.*;
import com.example.myhealthblock.opinion.adapter.out.jpa.*;
import com.example.myhealthblock.patient.adapter.out.jpa.*;
import com.example.myhealthblock.user.adapter.out.jpa.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("jpa")
public class JpaConfig {
    @Bean
    public DoctorOutputPort doctorOutputPort(DoctorRepository doctorRepository) {
        return new DoctorPersistenceAdapter(doctorRepository);
    }

    @Bean
    public PatientOutputPort patientOutputPort(PatientRepository patientRepository) {
        return new PatientPersistenceAdapter(patientRepository);
    }

    @Bean
    public QuestionOutputPort questionOutputPort(QuestionRepository questionRepository, PersonalDataRepository personalDataRepository, BodyMappingRepository bodyMappingRepository) {
        return new QuestionPersistenceAdapter(questionRepository, personalDataRepository, bodyMappingRepository);
    }

    @Bean
    public OpinionOutputPort opinionOutputPort(OpinionRepository opinionRepository) {
        return new OpinionPersistenceAdapter(opinionRepository);
    }

    @Bean
    public UserOutputPort userOutputPort(UserRepository userRepository) {
        return new UserPersistenceAdapter(userRepository);
    }
}