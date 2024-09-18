package com.example.myhealthblock.patient.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.myhealthblock.patient.adapter.out.database.jpa.PatientEntity;
import com.example.myhealthblock.patient.adapter.out.database.jpa.PatientPersistenceAdapter;
import com.example.myhealthblock.patient.adapter.out.database.jpa.PatientRepository;

/**
 * <b> 역할: 환자 영속성 어댑터 통합 테스트 클래스 </b>
 * <p>
 * - 실제 데이터베이스와의 상호작용을 검증하기 위한 통합 테스트 <br>
 * - 환자 생성 기능 검증 <br>
 * </p>
 */
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // 실제 데이터베이스 사용
@Transactional  // 각 테스트 메서드가 끝날 때마다 트랜잭션 롤백
public class PatientPersistenceAdapterIntegrationTest {

	@Autowired
	private PatientPersistenceAdapter patientPersistenceAdapter;

	@Autowired
	private PatientRepository patientRepository;

	/**
	 * <b> 역할: 테스트 초기화 메소드 </b>
	 * <p>
	 * - 각 테스트 전에 데이터베이스 초기화 <br>
	 * </p>
	 */
	@BeforeEach
	public void setUp() {
		patientRepository.deleteAll();
	}

	/**
	 * <b> 역할: 환자 생성 통합 테스트 </b>
	 * <p>
	 * - 환자를 생성하고, 데이터베이스에 제대로 저장되었는지 검증 <br>
	 * </p>
	 */
	@Test
	@DisplayName("환자 생성 통합 테스트")
	public void testCreatePatientIntegration() {
		// Given
		String id = "patient123";

		// When
		boolean result = patientPersistenceAdapter.create(id);

		// Then
		assertTrue(result, "환자 생성 성공!");
		PatientEntity savedPatient = patientRepository.findByUserId(id);
		assertNotNull(savedPatient, "DB에서 환자 조회 성공!");
	}
}
