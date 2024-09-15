package com.example.myhealthblock.question.application.port.out.dto;

import com.example.myhealthblock.question.common.BodyPart;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * <b>역할: 서비스 계층에서 영속성 계층으로 데이터를 전달하는 DTO 클래스</b>
 * <br>- 질문 등록 시 필요한 정보
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEnrollOutputPortRequest {
    int userId;
    List<BodyPart> bodyParts;
    Category category;
    String title;
    String symptom;
    String content;
    PersonalDataDTO personalData;
}
