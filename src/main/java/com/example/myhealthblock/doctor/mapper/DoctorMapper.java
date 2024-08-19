package com.example.myhealthblock.doctor.mapper;

import com.example.myhealthblock.doctor.domain.Doctor;
import com.example.myhealthblock.doctor.dto.DoctorSignUpRequestDTO;
import com.example.myhealthblock.doctor.dto.DoctorSignUpResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor dtoToDoctor(DoctorSignUpRequestDTO dto);

    @Mapping(source = "result", target = "result")
    DoctorSignUpResponseDTO doctorToDto(Doctor doctor, String result);
}
