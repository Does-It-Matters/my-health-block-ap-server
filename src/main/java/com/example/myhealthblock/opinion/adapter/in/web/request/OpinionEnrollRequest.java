//package com.example.myhealthblock.opinion.adapter.in.web.request;
//
//import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInportRequest;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class OpinionEnrollRequest {
//    int userId;
//    String content;
//    Integer questionId;
//
//    /**
//     * <b> 역할: 도메인 계층으로 전달하기 위해 입력 포트에서 전달되는 DTO를 매핑하는 메소드 </b>
//     * @return 입력 포트에서 전달되는 DTO
//     */
//    public OpinionEnrollInportRequest toInportDTO() {
//        return new OpinionEnrollInportRequest(
//                userId,
//                content,
//                questionId
//        );
//    }
//}
