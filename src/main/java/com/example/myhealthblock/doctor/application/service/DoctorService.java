//package com.example.myhealthblock.doctor.application.service;
//
//import com.example.myhealthblock.doctor.application.port.in.DoctorInport;
//import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInportResponse;
//import com.example.myhealthblock.doctor.application.port.out.DoctorOutport;
//import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutportResponse;
//import com.example.myhealthblock.doctor.domain.model.Doctor;
//import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportRequest;
//import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportResponse;
//import com.example.myhealthblock.doctor.domain.mapper.DoctorMapper;
//import com.example.myhealthblock.exception.UserAlreadyExistsException;
//import com.example.myhealthblock.user.application.port.in.UserSignUp;
//import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;
//import org.springframework.stereotype.Service;
//import lombok.RequiredArgsConstructor;
//
///**
// * <b> 역할: 의료진 회원 관리 비즈니스 로직을 처리하는 서비스 클래스 </b>
// * <br>- 의료진 회원 관리
// */
//@RequiredArgsConstructor
//@Service
//public class DoctorService implements DoctorInport {
//    private final DoctorOutport outport;
//    private final UserSignUp userInport;
//    private final DoctorMapper mapper = DoctorMapper.INSTANCE;
//
//    /**
//     * <b> 역할: 의료진 회원가입 메소드 </b>
//     * <br>- 최소한의 사용자 회원가입을 먼저 저장 시도
//     * <br>- 의료진 상세 정보 저장
//     * <br>- Transaction 으로 처리되어야 하는 코드
//     *
//     * @param dto 의료진 회원가입 요청 데이터
//     * @return 회원가입 성공 여부
//     */
//    @Override
//    public DoctorSignUpInportResponse signUp(DoctorSignUpInportRequest dto) {
//        requestUserSignUp(dto);
//        Doctor doctor = saveDoctorDetail(dto);
//        return getInportResponse(doctor);
//    }
//
//    /**
//     * <b> 역할: User 도메인으로 회원 가입 요청하는 메소드 </b>
//     * <br>- 회원가입 실패 시 이미 회원가입된 아이디로 예외 처리
//     * <br>- User 도메인 리팩토링 후 수정되어야 할 메소드
//     *
//     * @param dto 의료진 회원가입 요청 데이터
//     */
//    private void requestUserSignUp(DoctorSignUpInportRequest dto) {
//        UserSignUpRequest userSignUpDTO = getUserSignUpDTO(dto);
//        if (!userInport.signUp(userSignUpDTO)) {
//            throw new UserAlreadyExistsException("A user with this ID already exists.");
//        }
//    }
//
//    /**
//     * <b> 역할: 의료진 상세 정보 저장하는 메소드 </b>
//     * <br>- 아이디와 패스워드 저장 후 의료진 상세 정보를 저장
//     *
//     * @param dto 의료진 회원가입 요청 데이터
//     * @return 의료진 도메인 모델
//     */
//    private Doctor saveDoctorDetail(DoctorSignUpInportRequest dto) {
//        Doctor doctor = mapper.doctorSignUpInportRequestToDoctor(dto);
//        outport.create(mapper.doctorToDoctorSignUpOutportRequest(doctor));
//        return doctor;
//    }
//
//    /**
//     * <b> 역할: 회원 가입 후 응답 메소드 </b>
//     * <br>- 도메인 모델을 응답 dto로 매핑
//     *
//     * @param doctor 의료진 도메인
//     * return 응답 dto
//     */
//    private DoctorSignUpInportResponse getInportResponse(Doctor doctor) {
//        return mapper.doctorToDoctorSignUpInportResponse(doctor, "success");
//    }
//
//    /**
//     * <b> 역할: User 도메인에서 사용하는 회원 가입 요청 dto로 매핑하는 메소드 </b>
//     * <br>- User 도메인 리팩토링 후 수정되어야 할 메소드
//     *
//     * @param dto 의료진 회원가입 요청 데이터
//     * @return 매핑 dto
//     */
//    private UserSignUpRequest getUserSignUpDTO(DoctorSignUpInportRequest dto) {
//        UserSignUpRequest userSignUpDTO = new UserSignUpRequest();
//        userSignUpDTO.setId(dto.getId());
//        userSignUpDTO.setPw(dto.getPw());
//        userSignUpDTO.setRole(dto.getRole());
//
//        return userSignUpDTO;
//    }
//
//    /**
//     * <b> 역할: 의료진 프로필 조회 메소드 </b>
//     * <br>- 의료진 ID로 프로필 조회
//     *
//     * @param doctorId 의료진 ID
//     * @return 의료진 프로필 데이터
//     */
//    @Override
//    public DoctorProfileInportResponse getDoctorProfile(String doctorId) {
//        DoctorProfileOutportResponse outportResponse = outport.getDoctorProfile(doctorId);
//        return mapper.outportResponseToInportResponse(outportResponse);
//    }
//}
