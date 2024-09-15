package com.example.myhealthblock.doctor.domain.mapper;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInputPortResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutputPortResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutputPortRequest;
import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInputPortRequest;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInputPortResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor toDoctor(DoctorSignUpInputPortRequest dto);

    DoctorSignUpInputPortResponse toSignUpResponse(Doctor doctor);

    DoctorProfileInputPortResponse toInputResponse(DoctorProfileOutputPortResponse dto);

    DoctorSignUpOutputPortRequest toSignUpOutputPortRequest(Doctor doctor);
}
