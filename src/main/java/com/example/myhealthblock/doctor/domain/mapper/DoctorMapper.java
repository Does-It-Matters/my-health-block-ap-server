package com.example.myhealthblock.doctor.domain.mapper;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInputPortResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutportResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutportRequest;
import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInputPortRequest;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInputPortResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    // pw 여부로 암묵적 매핑 실패하여 명시적으로 매핑 설정
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "field", target = "field")
    @Mapping(source = "hospital", target = "hospital")
    @Mapping(source = "introduction", target = "introduction")
    Doctor toDoctor(DoctorSignUpInputPortRequest dto);

    DoctorSignUpInputPortResponse toSignUpResponse(Doctor doctor);

    DoctorProfileInputPortResponse toInputResponse(DoctorProfileOutportResponse dto);

    DoctorSignUpOutportRequest toSignUpOutputPortRequest(Doctor doctor);
}
