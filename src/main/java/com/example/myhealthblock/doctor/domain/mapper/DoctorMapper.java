package com.example.myhealthblock.doctor.domain.mapper;

import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportDTO;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor dtoToDoctor(DoctorSignUpInportDTO dto);

    @Mapping(source = "result", target = "result")
    DoctorSignUpOutportDTO doctorToDto(Doctor doctor, String result);
}
