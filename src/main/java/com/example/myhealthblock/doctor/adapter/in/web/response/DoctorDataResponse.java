//package com.example.myhealthblock.doctor.adapter.in.web.response;
//
//import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInportResponse;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
///**
// * <b> 역할: 의료진 프로필 조회에 대한 응답 정보 클래스 </b>
// * <br>- 의료진 프로필 정보
// */
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class DoctorDataResponse {
//    private String name;
//    private String field;
//    private String hospital;
//    private String introduction;
//
//    /**
//     * <b> 역할: 서비스 계층에서 넘어온 dto를 응답 객체에 매핑하는 메소드 </b>
//     * @param dto 서비스 계층에서 전달된 의료진 프로필 조회 dto
//     * @return 매핑된 응답 객체
//     */
//    public static DoctorDataResponse from(DoctorProfileInportResponse dto) {
//        return new DoctorDataResponse(
//                dto.getName(),
//                dto.getField(),
//                dto.getHospital(),
//                dto.getIntroduction()
//        );
//    }
//}
