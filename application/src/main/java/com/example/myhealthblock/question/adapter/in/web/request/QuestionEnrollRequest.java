package com.example.myhealthblock.question.adapter.in.web.request;

import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInputPortRequest;
import com.example.myhealthblock.question.common.BodyPart;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * <b> 역할: 질문 등록 요청 바디 클래스 </b>
 * <p>
 * - HTTP 요청 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEnrollRequest {
    int userId;
    List<BodyPart> bodyParts;
    Category category;
    String title;
    String symptom;
    String content;
    PersonalDataDTO personalData;


    /**
     * <b> 역할: 도메인 계층으로 전달하기 위해 입력 포트에서 전달되는 DTO를 매핑하는 메소드 </b>
     * @return 입력 포트에서 전달되는 DTO
     */
    public QuestionEnrollInputPortRequest toInputPortDTO() {
        return new QuestionEnrollInputPortRequest(
                userId,
                bodyParts,
                category,
                title,
                symptom,
                content,
                personalData
        );
    }
}
