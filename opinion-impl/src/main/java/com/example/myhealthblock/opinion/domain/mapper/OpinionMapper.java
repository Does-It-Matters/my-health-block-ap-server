package com.example.myhealthblock.opinion.domain.mapper;

import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInputPortRequest;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInputPortDTO;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutputPortDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OpinionMapper {
    OpinionMapper INSTANCE = Mappers.getMapper(OpinionMapper.class);

    OpinionInputPortDTO toEnrollInput(OpinionOutputPortDTO outportResponse);

    OpinionInputPortDTO[] toEnrollInputArray(OpinionOutputPortDTO[] outportDTOs);

    OpinionEnrollOutputPortRequest toEnrollOutputPortRequest(OpinionEnrollInputPortRequest outportResponse);
}
