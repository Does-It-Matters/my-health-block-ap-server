package com.example.myhealthblock.config.output.adapter;

import com.example.myhealthblock.doctor.application.port.out.DoctorOutputPort;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import com.example.myhealthblock.question.application.port.out.QuestionOutputPort;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;

import com.example.myhealthblock.doctor.adapter.out.mybatis.*;
import com.example.myhealthblock.opinion.adapter.out.mybatis.*;
import com.example.myhealthblock.patient.adapter.out.mybatis.*;
import com.example.myhealthblock.user.adapter.out.mybatis.*;
import com.example.myhealthblock.question.adapter.out.mybatis.bodypart.*;
import com.example.myhealthblock.question.adapter.out.mybatis.personaldata.*;
import com.example.myhealthblock.question.adapter.out.mybatis.question.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mybatis")
public class MyBatisConfig {
    @Bean
    public DoctorOutputPort doctorOutputPort(DoctorMapper doctorMapper) {
        return new DoctorPersistenceAdapter(doctorMapper);
    }

    @Bean
    public PatientOutputPort patientOutputPort(PatientMapper patientMapper) {
        return new PatientPersistenceAdapter(patientMapper);
    }

    @Bean
    public QuestionOutputPort questionOutputPort(QuestionMapper questionMapper, PersonalDataMapper personalDataMapper, BodyPartMappingMapper bodyPartMappingMapper) {
        return new QuestionPersistenceAdapter(questionMapper, personalDataMapper, bodyPartMappingMapper);
    }

    @Bean
    public OpinionOutputPort opinionOutputPort(OpinionMapper opinionMapper) {
        return new OpinionPersistenceAdapter(opinionMapper);
    }

    @Bean
    public UserOutputPort userOutputPort(UserMapper userMapper) {
        return new UserPersistenceAdapter(userMapper);
    }
}