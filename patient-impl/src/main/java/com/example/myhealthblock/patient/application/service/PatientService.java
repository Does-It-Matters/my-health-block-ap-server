package com.example.myhealthblock.patient.application.service;

import org.springframework.stereotype.Service;

import com.example.myhealthblock.patient.application.port.in.PatientInputPort;
import com.example.myhealthblock.patient.application.port.in.dto.PatientSignUpInputPortRequest;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import com.example.myhealthblock.patient.application.port.out.UserSignUpOutputPort;
import com.example.myhealthblock.patient.application.port.out.dto.PatientSignUpOutputPortToUserRequestDTO;

import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 환자 회원 관리 비즈니스 로직을 처리하는 서비스 클래스 </b>
 * <br>- 환자 회원 관리
 */
@RequiredArgsConstructor
@Service
public class PatientService implements PatientInputPort {
    private final PatientOutputPort outputPort;
    private final UserSignUpOutputPort userSignUpOutputPort;

    /**
     * <b> 역할: 환자 회원가입 메소드 </b>
     * <br>- 최소한의 사용자 회원가입을 먼저 저장 시도
     * <br>- 환자 상세 정보 저장
     * <br>- Transaction 으로 처리되어야 하는 코드
     *
     * @param dto 환자 회원가입 요청 데이터
     * @return 회원가입 성공 여부
     */
    @Override
    public boolean signUp(PatientSignUpInputPortRequest dto){
        requestUserSignUp(dto);
        return outputPort.create(dto.getId());
    }

    /**
     * <b> 역할: User 도메인으로 회원 가입 요청하는 메소드 </b>
     * <br>- 회원가입 실패 시 이미 회원가입된 아이디로 예외 처리
     *
     * @param dto 환자 회원가입 요청 데이터
     */
    private void requestUserSignUp(PatientSignUpInputPortRequest dto) {
        PatientSignUpOutputPortToUserRequestDTO userSignUpDTO = getUserSignUpDTO(dto);
        if (!userSignUpOutputPort.signUp(userSignUpDTO)) {
            throw new RuntimeException();
//            throw new UserAlreadyExistsException("A user with this ID already exists.");
        }
    }

    /**
     * <b> 역할: User 도메인에서 사용하는 회원 가입 요청 dto로 매핑하는 메소드 </b>
     *
     * @param dto 환자 회원가입 요청 데이터
     * @return 매핑 dto
     */
    private PatientSignUpOutputPortToUserRequestDTO getUserSignUpDTO(PatientSignUpInputPortRequest dto) {
        return new PatientSignUpOutputPortToUserRequestDTO(dto.getId(), dto.getPw(), dto.getRole());
    }
}
