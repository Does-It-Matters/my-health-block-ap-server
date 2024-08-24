//package com.example.myhealthblock.question.adapter.in.web.request;
//
//import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInportRequest;
//import com.example.myhealthblock.question.common.Category;
//import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class QuestionEnrollRequest {
//    int userId;
//    List<BodyPart> bodyParts;
//    Category category;
//    String title;
//    String symptom;
//    String content;
//    PersonalDataDTO personalData;
//
//
//    /**
//     * <b> 역할: 도메인 계층으로 전달하기 위해 입력 포트에서 전달되는 DTO를 매핑하는 메소드 </b>
//     * @return 입력 포트에서 전달되는 DTO
//     */
//    public QuestionEnrollInportRequest toInportDTO() {
//        return new QuestionEnrollInportRequest(
//                userId,
//                bodyParts,
//                category,
//                title,
//                symptom,
//                content,
//                personalData
//        );
//    }
//}
