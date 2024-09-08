package com.example.myhealthblock.question.domain.dto;

import com.example.myhealthblock.question.common.BodyPart;
import com.example.myhealthblock.question.common.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <b>역할: 질문 정보를 전달하는 DTO 클래스</b>
 * <p>
 * - 질문의 상세 정보를 포함하며, 다양한 계층 간 데이터 전송에 사용됨 <br>
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {
    Integer id;
    int uid;
    String title;
    Category category;
    String symptom;
    String content;
    List<BodyPart> bodyParts;
    PersonalDataDTO personalData;
}
