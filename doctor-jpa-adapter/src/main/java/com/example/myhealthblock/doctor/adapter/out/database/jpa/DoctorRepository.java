package com.example.myhealthblock.doctor.adapter.out.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b> 역할: 의료진 데이터에 대한 리포지토리 인터페이스 </b>
 * <br>- 의료진 리포지토리
 */
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {

    /**
     * <b> 역할: 사용자 ID로 의료진 엔티티 조회 메소드 </b>
     *
     * @param userId 의료진 ID
     * @return 의료진 엔티티
     */
    DoctorEntity findByUserId(String userId);
}
