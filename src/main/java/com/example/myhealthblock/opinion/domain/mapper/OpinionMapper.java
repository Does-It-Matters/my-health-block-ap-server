package com.example.myhealthblock.opinion.domain.mapper;

import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInportRequest;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInportDTO;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutportRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutportDTO;
import org.mapstruct.factory.Mappers;

public interface OpinionMapper {
    OpinionMapper INSTANCE = Mappers.getMapper(OpinionMapper.class);

    OpinionInportDTO opinionEnrollOutportResponseToOpinionEnrollInportResponse(OpinionOutportDTO outportResponse);
    OpinionInportDTO[] opinionOutportArrayToInportArray(OpinionOutportDTO[] outportDTOs);
    OpinionEnrollOutportRequest opinionEnrollOutportRequestToOpinionEnrollOutportResponse(OpinionEnrollInportRequest outportResponse);
}
