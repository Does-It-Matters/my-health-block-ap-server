package com.example.myhealthblock.config.output.adapter;

import com.example.myhealthblock.doctor.adapter.out.database.mybatis.DoctorMapper;
import com.example.myhealthblock.doctor.adapter.out.database.mybatis.DoctorPersistenceAdapter;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutputPort;
import com.example.myhealthblock.opinion.adapter.out.database.mybatis.OpinionMapper;
import com.example.myhealthblock.opinion.adapter.out.database.mybatis.OpinionPersistenceAdapter;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.patient.adapter.out.database.mybatis.PatientMapper;
import com.example.myhealthblock.patient.adapter.out.database.mybatis.PatientPersistenceAdapter;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import com.example.myhealthblock.question.adapter.out.database.mybatis.bodypart.BodyPartMappingMapper;
import com.example.myhealthblock.question.adapter.out.database.mybatis.personaldata.PersonalDataMapper;
import com.example.myhealthblock.question.adapter.out.database.mybatis.question.QuestionMapper;
import com.example.myhealthblock.question.adapter.out.database.mybatis.question.QuestionPersistenceAdapter;
import com.example.myhealthblock.question.application.port.out.QuestionOutputPort;
import com.example.myhealthblock.user.adapter.out.database.mybatis.UserMapper;
import com.example.myhealthblock.user.adapter.out.database.mybatis.UserPersistenceAdapter;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;

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