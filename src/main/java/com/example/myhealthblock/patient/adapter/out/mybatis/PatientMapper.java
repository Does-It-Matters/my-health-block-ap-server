package com.example.myhealthblock.patient.adapter.out.mybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper {

    /**
     * <b> 역할: 환자 생성 메소드 </b>
     * <p>
     * - 새로운 환자를 데이터베이스에 삽입 <br>
     * </p>
     *
     * @param patient 사용자 엔티티
     */
    void insertPatient(PatientEntity patient);
}