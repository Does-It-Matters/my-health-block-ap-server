package com.example.myhealthblock.config.output.adapter;

import com.example.myhealthblock.doctor.adapter.out.database.mongodb.DoctorPersistenceAdapter;
import com.example.myhealthblock.doctor.adapter.out.database.mongodb.DoctorRepository;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutputPort;
import com.example.myhealthblock.opinion.adapter.out.database.mongodb.OpinionPersistenceAdapter;
import com.example.myhealthblock.opinion.adapter.out.database.mongodb.OpinionRepository;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.patient.adapter.out.database.mongodb.PatientPersistenceAdapter;
import com.example.myhealthblock.patient.adapter.out.database.mongodb.PatientRepository;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;

import com.example.myhealthblock.doctor.adapter.out.mongodb.*;
import com.example.myhealthblock.patient.adapter.out.mongodb.*;
import com.example.myhealthblock.opinion.adapter.out.mongodb.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mongo")
public class MongoConfig {
    @Bean
    public DoctorOutputPort doctorOutputPort(DoctorRepository doctorRepository) {
        return new DoctorPersistenceAdapter(doctorRepository);
    }

    @Bean
    public PatientOutputPort patientOutputPort(PatientRepository patientRepository) {
        return new PatientPersistenceAdapter(patientRepository);
    }

//    @Bean
//    public QuestionOutputPort questionOutputPort(QuestionRepository questionRepository) {
////    id가 문자열이라서 현재 사용 불가
////        return new QuestionPersistenceAdapter(questionRepository);
//    }

    @Bean
    public OpinionOutputPort opinionOutputPort(OpinionRepository opinionRepository) {
        return new OpinionPersistenceAdapter(opinionRepository);
    }

//    @Bean
//    public UserOutputPort userOutputPort(UserRepository userRepository) {
//        return new UserPersistenceAdapter(userRepository);
//    }
}