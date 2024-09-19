package com.example.myhealthblock.doctor.application.port.out;

import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutputPortRequest;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutputPortResponse;

/**
 * <b> 역할: 의료진 데이터에 대한 출력 포트 인터페이스 </b>
 * <br>- 의료진 회원 관리
 * <br>- 육각형 아키텍처를 위한 출력 포트
 */
public interface DoctorOutputPort {

    /**
     * <b> 역할: 영속성 계층에 의료진 정보를 저장하는 메소드 </b>
     *
     * @param doctor 영속성 계층에 전달할 도메인 객체
     * @return 성공하면 true, 실패하면 false
     */
    boolean create(DoctorSignUpOutputPortRequest doctor);

    /**
     * <b> 역할: 의료진 프로필 조회 메소드 </b>
     *
     * @param doctorId 의료진 ID
     * @return 의료진 프로필 정보
     */
    public DoctorProfileOutputPortResponse getDoctorProfile(String doctorId);
}
