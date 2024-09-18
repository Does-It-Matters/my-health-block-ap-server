package com.example.myhealthblock.doctor.adapter.out.database.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DoctorMapper {

    void insertDoctor(DoctorEntity doctor);

    DoctorEntity selectDoctorByUserId(@Param("userId") String userId);
}
