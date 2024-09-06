package com.example.myhealthblock.patient.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.myhealthblock.patient.adapter.out.jpa.PatientEntity;
import com.example.myhealthblock.patient.adapter.out.jpa.PatientPersistenceAdapter;
import com.example.myhealthblock.patient.adapter.out.jpa.PatientRepository;

/**
 * <b> 역할: 환자 영속성 어댑터 단위 테스트 클래스 </b>
 * <p>
 * - {@link PatientPersistenceAdapter} 클래스의 기능을 단위 테스트로 검증 <br>
 * - 데이터베이스와의 상호작용을 모의 객체로 대체하여 로직을 검증 <br>
 * </p>
 */
public class PatientPersistenceAdapterTest {

	@InjectMocks
	private PatientPersistenceAdapter patientPersistenceAdapter;

	@Mock
	private PatientRepository patientRepository;

	/**
	 * <b> 역할: 테스트 초기화 메소드 </b>
	 * <p>
	 * - 모의 객체 초기화 및 테스트 클래스 준비 <br>
	 * </p>
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * <b> 역할: 환자 생성 단위 테스트 </b>
	 * <p>
	 * - 환자 생성 로직을 검증하고, 모의 객체의 상호작용을 확인 <br>
	 * </p>
	 */
	@Test
	@DisplayName("환자 생성 성공 테스트 케이스")
	public void testCreatePatientSuccess() {
		// Given
		String id = "patient123";

		// When
		boolean result = patientPersistenceAdapter.create(id);

		// Then
		assertTrue(result, "환자 생성 성공!");
		verify(patientRepository).save(any(PatientEntity.class));
	}
}
