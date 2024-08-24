package com.example.myhealthblock.user.adapter.out.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> 역할: 사용자 영속성 리포지토리 통합 테스트 클래스 </b>
 * <p>
 * - {@link UserRepository} 인터페이스의 기능을 통합 테스트로 검증 <br>
 * - 데이터베이스와의 상호작용 검증 <br>
 * </p>
 */
@DataJpaTest
class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * <b> 역할: 사용자 정보 저장 메소드 </b>
     * <p>
     * - 리포지토리를 활용하여 사용자 정보 저장 테스트 <br>
     * </p>
     */
    @Test
    @DisplayName("사용자 정보 저장 성공 테스트 케이스")
    void testSaveAndFindUser() {
        // Given
        UserEntity user = new UserEntity();
        user.setUserId("user");
        user.setPw("password");
        user.setRole("PATIENT");

        // When
        userRepository.save(user);
        UserEntity foundUser = userRepository.findById(user.getId()).orElse(null);

        // Then
        assertNotNull(foundUser);
        assertEquals("user", foundUser.getUserId());
    }
}