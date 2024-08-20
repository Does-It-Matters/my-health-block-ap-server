package com.example.myhealthblock.doctor.domain.mapper;

import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.domain.dto.DoctorSignUpRequestDTO;
import com.example.myhealthblock.doctor.domain.dto.DoctorSignUpResponseDTO;
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
