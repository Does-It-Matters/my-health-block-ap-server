package com.example.myhealthblock.patient.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b> 역할: 환자 레포지토리 인터페이스 </b>
 * <p>
 * - {@link JpaRepository} 상속하여 기본적인 CRUD 제공 <br>
 * - {@link PatientEntity} 엔티티 관리 <br>
 * </p>
 */
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

	/**
	 * <b> 역할: 환자 ID로 환자 조회 </b>
	 * <p>
	 *
	 * @param userId 조회할 환자 ID
	 * @return 환자 ID와 일치하는 {@link PatientEntity} 객체, 없으면 {@code null}
	 */
	PatientEntity findByUserId(String userId);
}
