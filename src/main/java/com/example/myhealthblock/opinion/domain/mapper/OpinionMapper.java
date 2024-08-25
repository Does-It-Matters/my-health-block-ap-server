package com.example.myhealthblock.opinion.domain.mapper;

import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInputPortRequest;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInputPortDTO;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutputPortDTO;
import org.mapstruct.factory.Mappers;

public interface OpinionMapper {
    OpinionMapper INSTANCE = Mappers.getMapper(OpinionMapper.class);

    OpinionInputPortDTO opinionEnrollOutportResponseToOpinionEnrollInportResponse(OpinionOutputPortDTO outportResponse);
    OpinionInputPortDTO[] opinionOutportArrayToInportArray(OpinionOutputPortDTO[] outportDTOs);
    OpinionEnrollOutputPortRequest opinionEnrollOutportRequestToOpinionEnrollOutportResponse(OpinionEnrollInputPortRequest outportResponse);
}
