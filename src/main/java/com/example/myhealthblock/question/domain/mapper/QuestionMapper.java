package com.example.myhealthblock.question.domain.mapper;

import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInportRequest;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutportRequest;
import org.mapstruct.factory.Mappers;

public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionEnrollOutportRequest inportRequestToOutportRequest(QuestionEnrollInportRequest inportRequest);
}
