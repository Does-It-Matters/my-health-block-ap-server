package com.example.myhealthblock.patient.application.port.in;

import com.example.myhealthblock.patient.application.port.in.dto.PatientSignUpInputPortRequest;

public interface PatientSignUp {
	/**
	 * <b> 역할: 환자 생성 요청 메소드 </b>
	 * <p>
	 *
	 * @param dto  환자 생성에 필요한 정보를 가진 dto
	 * @return 환자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
	 * </p>
	 */
	boolean signUp(PatientSignUpInputPortRequest dto);
}