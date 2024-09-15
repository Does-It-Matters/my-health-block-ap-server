package com.example.myhealthblock.user.adapter.out.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.myhealthblock.user.adapter.out.jpa.UserEntity;
import com.example.myhealthblock.user.adapter.out.jpa.UserPersistenceAdapter;
import com.example.myhealthblock.user.adapter.out.jpa.UserRepository;
import com.example.myhealthblock.user.domain.model.User;

/**
 * <b> 역할: 사용자 영속성 어댑터 단위 테스트 클래스 </b>
 * <p>
 * - {@link UserPersistenceAdapter} 클래스의 기능을 단위 테스트로 검증 <br>
 * - 데이터베이스와의 상호작용을 모의 객체로 대체하여 로직을 검증 <br>
 * </p>
 */
public class UserPersistenceAdapterTest {

    @InjectMocks
    private UserPersistenceAdapter userPersistenceAdapter;

    @Mock
    private UserRepository userRepository;

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
     * <b> 역할: 사용자 생성 단위 테스트 </b>
     * <p>
     * - 사용자 생성 로직을 검증하고, 모의 객체의 상호작용을 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("사용자 생성 성공 테스트 케이스")
    public void testCreateUserSuccess() {
        // Given
        String id = "user123";
        String pw = "password123";
        String role = "DOCTOR";

        // When
        boolean result = userPersistenceAdapter.create(id, pw, role);

        // Then
        assertTrue(result, "사용자 생성 성공!");
        verify(userRepository).save(any(UserEntity.class));
    }

    /**
     * <b> 역할: 사용자 조회 실패 단위 테스트 </b>
     * <p>
     * - 존재하지 않는 사용자 조회 시도 시 결과를 검증 <br>
     * </p>
     */
    @Test
    @DisplayName("사용자 조회 실패 테스트 케이스")
    public void testGetUserFailure() {
        // Given
        String userId = "user123";

        when(userRepository.findByUserId(userId)).thenReturn(null);

        // When
        User user = userPersistenceAdapter.getUser(userId);

        // Then
        assertNull(user, "사용자 조회 실패!");
    }


    /**
     * <b> 역할: 사용자 비밀번호 갱신 단위 테스트 </b>
     * <p>
     * - 사용자 비밀번호 업데이트 로직을 검증 <br>
     * - 모의 객체의 상호작용을 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("비밀번호 변경 성공 테스트 케이스")
    public void testUpdatePwSuccess() {
        // Given
        String userId = "user123";
        String newPw = "newpassword123";
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setPw("password123");

        when(userRepository.findByUserId(userId)).thenReturn(userEntity);

        // When
        boolean result = userPersistenceAdapter.updatePw(userId, newPw);

        // Then
        assertTrue(result, "비밀번호 변경 성공!");
        verify(userRepository).save(userEntity);
        assertEquals(newPw, userEntity.getPw(), "변경된 비밀번호 확인");
    }

    /**
     * <b> 역할: 비밀번호 갱신 실패 단위 테스트 </b>
     * <p>
     * - 기존의 비밀번호와 일치하지 않는 비밀번호로 시도 시 결과를 검증 <br>
     * </p>
     */
    @Test
    @DisplayName("기존의 비밀번호와 일치하지 않아, 비밀번호 변경 실패 테스트 케이스")
    public void testUpdatePwFailure() {
        // Given
        String userId = "user123";
        String newPw = "newpassword123";

        when(userRepository.findByUserId(userId)).thenReturn(null);

        // When
        boolean result = userPersistenceAdapter.updatePw(userId, newPw);

        // Then
        assertFalse(result, "비밀번호 변경 실패!");
    }
}