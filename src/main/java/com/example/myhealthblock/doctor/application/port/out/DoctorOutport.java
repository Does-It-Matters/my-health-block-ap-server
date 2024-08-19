package com.example.myhealthblock.doctor.application.port.out;

import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.domain.dto.DoctorProfileDTO;

/**
 * <b> 역할: 의료진 데이터에 대한 출력 포트 인터페이스 </b>
 * <br>- 의료진 회원 관리
 * <br>- 육각형 아키텍처를 위한 출력 포트
 */
public interface DoctorOutport {
    boolean create(Doctor doctor);

    /**
     * <b> 역할: 의료진 데이터 저장 메소드 </b>
     *
     * @param id           의료진 ID
     * @param name         의료진 이름
     * @param field        전문 분야
     * @param hospital     병원명
     * @param introduction 자기소개
     * @return 저장 성공 여부
     */
    public boolean create(String id, String name, String field, String hospital, String introduction);

    /**
     * <b> 역할: 의료진 프로필 조회 메소드 </b>
     *
     * @param doctorId 의료진 ID
     * @return 의료진 프로필 정보
     */
    public DoctorProfileDTO getDoctorProfile(String doctorId);
}
