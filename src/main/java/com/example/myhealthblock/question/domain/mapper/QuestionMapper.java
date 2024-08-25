package com.example.myhealthblock.question.domain.mapper;

import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInputPortRequest;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "bodyParts", target = "bodyParts")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "symptom", target = "symptom")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "personalData", target = "personalData")
    QuestionEnrollOutputPortRequest toOutputPortRequest(QuestionEnrollInputPortRequest inportRequest);
}
