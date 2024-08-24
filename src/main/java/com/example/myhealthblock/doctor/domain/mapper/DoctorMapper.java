package com.example.myhealthblock.doctor.domain.mapper;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInportResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutportResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutportRequest;
import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportRequest;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor doctorSignUpInportRequestToDoctor(DoctorSignUpInportRequest dto);

    DoctorSignUpInportResponse doctorToDoctorSignUpInportResponse(Doctor doctor);

    DoctorProfileInportResponse outportResponseToInportResponse(DoctorProfileOutportResponse dto);

    DoctorSignUpOutportRequest doctorToDoctorSignUpOutportRequest(Doctor doctor);
}
