package com.example.myhealthblock.patient.adapter.out.persistence;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.myhealthblock.patient.adapter.out.jpa.PatientEntity;
import com.example.myhealthblock.patient.adapter.out.jpa.PatientRepository;

/**
 * <b> 역할: {@link PatientEntity} 클래스의 단위 테스트 클래스 </b>
 * <p>
 * - Create 정상 작동 검증 <br>
 * </p>
 */
// @DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class PatientEntityTest {

	@Autowired
	private PatientRepository patientRepository;

	private PatientEntity patientEntity;

	/**
	 * <b> 역할: 테스트 전 {@link PatientEntity} 초기화 메소드 </b>
	 * <p>
	 * - PatientEntity 기본 정보 설정 <br>
	 * </p>
	 */
	@BeforeEach
	public void setUp() {
		patientEntity = new PatientEntity();
		patientEntity.setUserId("patient123");
		patientEntity.setUrgentData("사용자의 응급 데이터");
	}

	/**
	 * <b> 역할: {@link PatientEntity} 저장 테스트 메소드 </b>
	 * <p>
	 * - 저장 후 자동 생성된 ID와 설정한 필드 값 검증 <br>
	 * </p>
	 */
	@Test
	@DisplayName("PatientEntity 저장 테스트")
	public void testSavePatientEntity() {
		PatientEntity savedPatient = patientRepository.save(patientEntity);

		assertThat(savedPatient.getId()).isNotNull();
		assertThat(savedPatient.getUserId()).isEqualTo("patient123");
		assertThat(savedPatient.getUrgentData()).isEqualTo("사용자의 응급 데이터");
	}
}
