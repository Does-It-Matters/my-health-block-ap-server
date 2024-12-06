package com.example.myhealthblock.patient.application.port.out;

/**
 * <b> 역할: 환자 출력 포트 인터페이스 </b>
 * <p>
 * - 도메인 계층에서 어댑터 계층으로 데이터를 전달하는 인터페이스 <br>
 * - 환자 생성 기능 정의 <br>
 * </p>
 */
public interface PatientOutputPort {

    /**
     * <b> 역할: 환자 생성 메소드 </b>
     * <p>
     * - 아이디로 환자 생성 <br>
     * </p>
     *
     * @param id  생성할 환자의 ID
     * @return 사용자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     */
    boolean create(String id);
}
