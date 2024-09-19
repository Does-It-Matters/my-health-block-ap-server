package com.example.myhealthblock.patient.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.myhealthblock.patient.application.port.in.dto.PatientSignUpInputPortRequest;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;

/**
 * <b> 역할: {@link PatientService} 통합 테스트 클래스 </b>
 * <p>
 * - 실제 데이터베이스와의 상호작용을 검증하기 위한 통합 테스트 <br>
 * - 환자 회원가입 기능 검증 <br>
 * </p>
 */
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class PatientServiceIntegrationTest {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientOutputPort patientOutputPort;

	/**
	 * <b> 역할: 각 테스트 전에 데이터베이스를 초기화하는 메서드 </b>
	 * <p>
	 * - 테스트가 시작되기 전에 데이터베이스를 초기 상태로 만듭니다. <br>
	 * </p>
	 */
	@BeforeEach
	public void setUp() {
	}

	/**
	 * <b> 역할: 환자 회원가입 통합 테스트 </b>
	 * <p>
	 * - 환자를 회원가입시키고 데이터베이스에 제대로 저장되었는지 검증합니다. <br>
	 * </p>
	 */
	@Test
	@DisplayName("회원가입 통합 테스트")
	public void testSignUpIntegration() {
		// Given
		String id = "integrationPatient";
		PatientSignUpInputPortRequest signUpRequest = new PatientSignUpInputPortRequest();
		signUpRequest.setId(id);
		signUpRequest.setPw("password123");
		signUpRequest.setRole("PATIENT");

		// When
		boolean result = patientService.signUp(signUpRequest);

		// Then
		assertTrue(result, "회원가입 성공");
	}
}
