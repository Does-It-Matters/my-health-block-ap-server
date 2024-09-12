package com.example.myhealthblock.question.domain.mapper;

import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInputPortRequest;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <b>역할: 질문 등록 관련 DTO 간 매핑을 수행하는 인터페이스</b>
 * <p>
 * - MapStruct를 사용하여 QuestionEnrollInputPortRequest를 QuestionEnrollOutputPortRequest로 변환 <br>
 * - 입력 포트 요청 DTO를 출력 포트 요청 DTO로 매핑하는 메서드 제공 <br>
 * </p>
 */
@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    /**
     * QuestionEnrollInputPortRequest를 QuestionEnrollOutputPortRequest로 변환
     * @param inportRequest 입력 포트 요청 DTO
     * @return 출력 포트 요청 DTO
     */
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "bodyParts", target = "bodyParts")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "symptom", target = "symptom")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "personalData", target = "personalData")
    QuestionEnrollOutputPortRequest toOutputPortRequest(QuestionEnrollInputPortRequest inportRequest);
}
