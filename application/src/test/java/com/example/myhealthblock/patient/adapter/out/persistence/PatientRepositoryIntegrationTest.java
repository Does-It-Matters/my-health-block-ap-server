package com.example.myhealthblock.patient.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.myhealthblock.patient.adapter.out.database.jpa.PatientEntity;
import com.example.myhealthblock.patient.adapter.out.database.jpa.PatientRepository;

/**
 * <b> 역할: 환자 영속성 리포지토리 통합 테스트 클래스 </b>
 * <p>
 * - {@link PatientRepository} 인터페이스의 기능을 통합 테스트로 검증 <br>
 * - 데이터베이스와의 상호작용 검증 <br>
 * </p>
 */
@DataJpaTest
public class PatientRepositoryIntegrationTest {

	@Autowired
	private PatientRepository patientRepository;

	/**
	 * <b> 역할: 환자 정보 저장 메소드 </b>
	 * <p>
	 * - 리포지토리를 활용하여 환자 정보 저장 테스트 <br>
	 * </p>
	 */
	@Test
	@DisplayName("환자 정보 저장 성공 테스트 케이스")
	void testSaveAndFindPatient() {
		// Given
		PatientEntity patient = new PatientEntity();
		patient.setUserId("patient123");
		patient.setUrgentData("사용자의 응급 데이터");

		// When
		patientRepository.save(patient);
		PatientEntity foundPatient = patientRepository.findById(patient.getId()).orElse(null);

		// Then
		assertNotNull(foundPatient);
		assertEquals("patient123", foundPatient.getUserId());
	}
}
