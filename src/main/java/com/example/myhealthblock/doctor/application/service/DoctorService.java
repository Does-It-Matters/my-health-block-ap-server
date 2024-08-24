package com.example.myhealthblock.doctor.application.service;

import com.example.myhealthblock.doctor.application.port.in.DoctorInport;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInportResponse;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutport;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutportResponse;
import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportRequest;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportResponse;
import com.example.myhealthblock.doctor.domain.mapper.DoctorMapper;
import com.example.myhealthblock.exception.UserAlreadyExistsException;
import com.example.myhealthblock.user.application.port.in.UserSignUp;
import com.example.myhealthblock.user.application.port.in.dto.UserSignUpInputPortRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 의료진 회원 관리 비즈니스 로직을 처리하는 서비스 클래스 </b>
 * <p>
 * - 의료진 회원 관리 <br>
 * </p>
 */
@RequiredArgsConstructor
@Service
public class DoctorService implements DoctorInport {
    private final DoctorOutport outputPort;
    private final UserSignUp userInputPort;
    private final DoctorMapper mapper = DoctorMapper.INSTANCE;

    /**
     * <b> 역할: 의료진 회원가입 메소드 </b>
     * <p>
     * - 최소한의 사용자 회원가입을 먼저 저장 시도 <br>
     * - 의료진 상세 정보 저장 <br>
     * - Transaction 으로 처리되어야 하는 코드 <br>
     *
     * @param dto 의료진 회원가입 요청 데이터
     * @return 회원가입 성공 여부
     * </p>
     */
    @Override
    public DoctorSignUpInportResponse signUp(DoctorSignUpInportRequest dto) {
        requestUserSignUp(dto);
        Doctor doctor = saveDoctorDetail(dto);
        return getInputPortResponse(doctor);
    }

    /**
     * <b> 역할: User 도메인으로 회원 가입 요청하는 메소드 </b>
     * <p>
     * - 회원가입 실패 시 이미 회원가입된 아이디로 예외 처리 <br>
     * - User 도메인 리팩토링 후 수정되어야 할 메소드 <br>
     *
     * @param dto 의료진 회원가입 요청 데이터
     * </p>
     */
    private void requestUserSignUp(DoctorSignUpInportRequest dto) {
        UserSignUpInputPortRequest userSignUpDTO = getUserSignUpDTO(dto);
        if (!userInputPort.signUp(userSignUpDTO)) {
            throw new UserAlreadyExistsException("A user with this ID already exists.");
        }
    }

    /**
     * <b> 역할: 의료진 상세 정보 저장하는 메소드 </b>
     * <p>
     * - 아이디와 패스워드 저장 후 의료진 상세 정보를 저장 <br>
     *
     * @param dto 의료진 회원가입 요청 데이터
     * @return 의료진 도메인 모델
     * </p>
     */
    private Doctor saveDoctorDetail(DoctorSignUpInportRequest dto) {
        Doctor doctor = mapper.doctorSignUpInportRequestToDoctor(dto);
        outputPort.create(mapper.doctorToDoctorSignUpOutportRequest(doctor));
        return doctor;
    }

    /**
     * <b> 역할: 회원 가입 후 응답 메소드 </b>
     * <p>
     * - 도메인 모델을 응답 dto로 매핑 <br>
     *
     * @param doctor 의료진 도메인
     * @return 응답 dto
     * </p>
     */
    private DoctorSignUpInportResponse getInputPortResponse(Doctor doctor) {
        return mapper.doctorToDoctorSignUpInportResponse(doctor);
    }

    /**
     * <b> 역할: User 도메인에서 사용하는 회원 가입 요청 dto로 매핑하는 메소드 </b>
     * <p>
     * - User 도메인 리팩토링 후 수정되어야 할 메소드 <br>
     *
     * @param dto 의료진 회원가입 요청 데이터
     * @return 매핑 dto
     * </p>
     */
    private UserSignUpInputPortRequest getUserSignUpDTO(DoctorSignUpInportRequest dto) {
        UserSignUpInputPortRequest userSignUpDTO = new UserSignUpInputPortRequest();
        userSignUpDTO.setId(dto.getId());
        userSignUpDTO.setPw(dto.getPw());
        userSignUpDTO.setRole(dto.getRole());

        return userSignUpDTO;
    }

    /**
     * <b> 역할: 의료진 프로필 조회 메소드 </b>
     * <p>
     * - 의료진 ID로 프로필 조회 <br>
     *
     * @param doctorId 의료진 ID
     * @return 의료진 프로필 데이터
     * </p>
     */
    @Override
    public DoctorProfileInportResponse getDoctorProfile(String doctorId) {
        DoctorProfileOutportResponse outportResponse = outputPort.getDoctorProfile(doctorId);
        return mapper.outportResponseToInportResponse(outportResponse);
    }
}
