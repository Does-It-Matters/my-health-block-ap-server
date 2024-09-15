package com.example.myhealthblock.doctor.application.port.out;

import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutputPortToUserRequest;

/**
 * <b> 역할: User 도메인의 회원 가입 관련 의료진 출력 포트 인터페이스 </b>
 * <br>- User 도메인에 회원가입 요청
 * <br>- 육각형 아키텍처를 위한 출력 포트
 */
public interface UserSignUpOutputPort {

    /**
     * <b> 역할: 사용자 생성 요청 메소드 </b>
     * <p>
     *
     * @param dto  사용자 생성에 필요한 정보를 가진 dto
     * @return 사용자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     * </p>
     */
    boolean signUp(DoctorSignUpOutputPortToUserRequest dto);
}
