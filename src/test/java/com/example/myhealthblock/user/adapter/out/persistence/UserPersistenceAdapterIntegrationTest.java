package com.example.myhealthblock.user.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.myhealthblock.user.adapter.out.jpa.UserEntity;
import com.example.myhealthblock.user.adapter.out.jpa.UserPersistenceAdapter;
import com.example.myhealthblock.user.adapter.out.jpa.UserRepository;
import com.example.myhealthblock.user.domain.model.User;

/**
 * <b> 역할: 사용자 영속성 어댑터 통합 테스트 클래스 </b>
 * <p>
 * - 실제 데이터베이스와의 상호작용을 검증하기 위한 통합 테스트 <br>
 * - 사용자 생성, 조회, 비밀번호 변경 등의 기능을 검증 <br>
 * </p>
 */
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // 실제 데이터베이스 사용
@Transactional  // 각 테스트 메서드가 끝날 때마다 트랜잭션 롤백
public class UserPersistenceAdapterIntegrationTest {

    @Autowired
    private UserPersistenceAdapter userPersistenceAdapter;

    @Autowired
    private UserRepository userRepository;

    /**
     * <b> 역할: 테스트 초기화 메소드 </b>
     * <p>
     * - 각 테스트 전에 데이터베이스 초기화 <br>
     * </p>
     */
    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }


    /**
     * <b> 역할: 사용자 생성 통합 테스트 </b>
     * <p>
     * - 사용자를 생성하고, 데이터베이스에 제대로 저장되었는지 검증 <br>
     * </p>
     */
    @Test
    @DisplayName("사용자 생성 통합 테스트")
    public void testCreateUserIntegration() {
        // Given
        String id = "user123";
        String pw = "password123";
        String role = "DOCTOR";

        // When
        boolean result = userPersistenceAdapter.create(id, pw, role);

        // Then
        assertTrue(result, "사용자 생성 성공!");
        UserEntity savedUser = userRepository.findByUserId(id);
        assertNotNull(savedUser, "DB에서 사용자 조회 성공!");
        assertEquals(pw, savedUser.getPw(), "저장된 비밀번호 확인");
        assertEquals(role, savedUser.getRole(), "저장된 역할 확인");
    }

    /**
     * <b> 역할: 사용자 조회 통합 테스트 </b>
     * <p>
     * - 사용자 조회 기능이 정상 작동하는지 검증 <br>
     * </p>
     */
    @Test
    @DisplayName("사용자 조회 통합 테스트")
    public void testGetUserIntegration() {
        // Given
        String userId = "user123";
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setPw("password123");
        userEntity.setRole("DOCTOR");
        userRepository.save(userEntity);

        // When
        User user = userPersistenceAdapter.getUser(userId);

        // Then
        assertNotNull(user, "사용자 조회 성공!");
        assertEquals(userId, user.getUid(), "사용자 ID 확인");
        assertEquals("password123", user.getPw(), "비밀번호 확인");
        assertEquals("DOCTOR", user.getRole(), "역할 확인");
    }


    /**
     * <b> 역할: 비밀번호 변경 통합 테스트 </b>
     * <p>
     * - 사용자의 비밀번호를 변경하고, 그 결과를 검증 <br>
     * </p>
     */
    @Test
    @DisplayName("비밀번호 변경 통합 테스트")
    public void testUpdatePwIntegration() {
        // Given
        String userId = "user123";
        String oldPw = "password123";
        String newPw = "newpassword123";
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setPw(oldPw);
        userEntity.setRole("DOCTOR");
        userRepository.save(userEntity);

        // When
        boolean result = userPersistenceAdapter.updatePw(userId, newPw);

        // Then
        assertTrue(result, "비밀번호 변경 성공!");
        UserEntity updatedUser = userRepository.findByUserId(userId);
        assertEquals(newPw, updatedUser.getPw(), "변경된 비밀번호 확인");
    }

    /**
     * <b> 역할: 사용자 조회 실패 통합 테스트 </b>
     * <p>
     * - 존재하지 않는 사용자 조회 시도 시 결과를 검증 <br>
     * </p>
     */
    @Test
    @DisplayName("존재하지 않는 아이디로 조회하여, 사용자 조회 실패 통합 테스트")
    public void testGetUserFailureIntegration() {
        // Given
        String userId = "nonExistingUser";

        // When
        User user = userPersistenceAdapter.getUser(userId);

        // Then
        assertNull(user, "존재하지 않는 사용자 조회 실패!");
    }
}