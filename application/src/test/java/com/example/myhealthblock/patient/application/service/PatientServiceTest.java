package com.example.myhealthblock.patient.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.myhealthblock.patient.application.port.in.dto.PatientSignUpInputPortRequestDTO;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import com.example.myhealthblock.patient.domain.model.Patient;

/**
 * <b> 역할: {@link PatientService} 단위 테스트 클래스 </b>
 * <p>
 * - 모의 객체를 사용하여 {@link PatientService}의 비즈니스 로직을 검증 <br>
 * - 환자 회원가입 기능 검증 <br>
 * </p>
 */
public class PatientServiceTest {

	@InjectMocks
	private PatientService patientService;

	@Mock
	private PatientOutputPort patientOutputPort;

	@Mock
	private Patient patient; // Patient 객체를 Mock으로 사용

	/**
	 * <b> 역할: 테스트 초기화 메소드 </b>
	 * <p>
	 * - 모의 객체를 초기화하여 테스트 준비 <br>
	 * </p>
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * <b> 역할: 환자 회원가입 성공 단위 테스트 </b>
	 * <p>
	 * - 새로운 환자가 성공적으로 가입되는지 검증합니다. <br>
	 * </p>
	 */
	@Test
	@DisplayName("회원가입 성공 테스트")
	public void testSignUpSuccess() {
		// Given
		String id = "newPatient";
		PatientSignUpInputPortRequestDTO signUpRequest = new PatientSignUpInputPortRequestDTO();
		signUpRequest.setId(id);

		// Mock behavior 설정
		when(patientOutputPort.create(id)).thenReturn(true);

		// When
		boolean result = patientService.signUp(signUpRequest);

		// Then
		assertTrue(result, "회원가입 성공");
		verify(patientOutputPort).create(id);
	}

	/**
	 * <b> 역할: 이미 존재하는 환자로 인한 회원가입 실패 단위 테스트 </b>
	 * <p>
	 * - 이미 존재하는 환자 ID로 가입 시도 시 실패를 검증합니다. <br>
	 * </p>
	 */
	@Test
	@DisplayName("이미 존재하는 환자로 인해 회원가입 실패 테스트")
	public void testSignUpFailure() {
		// Given
		String id = "existingPatient";
		PatientSignUpInputPortRequestDTO signUpRequest = new PatientSignUpInputPortRequestDTO();
		signUpRequest.setId(id);
		signUpRequest.setPw("password123");
		signUpRequest.setRole("PATIENT");

		// When
		boolean result = patientService.signUp(signUpRequest);

		// Then
		assertFalse(result, "이미 존재하는 환자로 인해 회원가입 실패");
	}
}
