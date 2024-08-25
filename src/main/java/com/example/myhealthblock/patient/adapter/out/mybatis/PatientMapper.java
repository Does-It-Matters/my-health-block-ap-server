package com.example.myhealthblock.patient.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper {

    void insertPatient(PatientEntity patient);
}