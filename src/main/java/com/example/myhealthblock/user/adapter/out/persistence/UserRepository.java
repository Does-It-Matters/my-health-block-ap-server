package com.example.myhealthblock.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b> 역할: 사용자 레포지토리 인터페이스 </b>
 * <p>
 * - {@link JpaRepository} 상속하여 기본적인 CRUD 제공 <br>
 * - {@link UserEntity} 엔티티 관리 <br>
 * </p>
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

    /**
     * <b> 역할: 사용자 ID로 사용자 조회 </b>
     * <p>
     *
     * @param userId 조회할 사용자 ID
     * @return 사용자 ID와 일치하는 {@link UserEntity} 객체, 없으면 {@code null}
     */
    UserEntity findByUserId(String userId);
}
