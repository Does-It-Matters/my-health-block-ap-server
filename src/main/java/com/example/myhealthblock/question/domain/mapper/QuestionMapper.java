package com.example.myhealthblock.question.domain.mapper;

import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInportRequest;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionEnrollOutputPortRequest inportRequestToOutportRequest(QuestionEnrollInportRequest inportRequest);
}
