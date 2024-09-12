package com.example.myhealthblock.user.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <b> 역할: {@link User} 클래스 단위 테스트 클래스 </b>
 */
public class UserTest {
    private User user;

    /**
     * <b> 역할: 테스트 전 {@link User} 초기화 메소드 </b>
     * <p>
     * - 각 테스트 코드 실행 전 실행 <br>
     * </p>
     */
    @BeforeEach
    public void setUp() {
        user = new User("1", "user123", "password123", "DOCTOR");
    }

    /**
     * <b> 역할: {@link User#signIn(String)} 성공 메소드 </b>
     * <p>
     * - 비밀번호가 맞는 경우, {@code signIn} 메서드가 {@code true} 반환하는 지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("로그인 성공 테스트 케이스")
    public void testSignInSuccess() {
        boolean result = user.signIn("password123");
        assertTrue(result, "로그인 성공!");
    }

    /**
     * <b> 역할: {@link User#signIn(String)} 실패 메소드 </b>
     * <p>
     * - 비밀번호가 틀린 경우, {@code signIn} 메서드가 {@code false} 반환하는 지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("비밀번호가 틀려서, 로그인 실패 테스트 케이스")
    public void testSignInFailure() {
        boolean result = user.signIn("password");
        assertFalse(result, "로그인 실패!");
    }

    /**
     * <b> 역할: {@link User#changePw(String, String)} 성공 메소드 </b>
     * <p>
     * - 비밀번호 변경이 성공한 경우, {@code changePw} 메서드가 {@code true} 반환하는지 확인 <br>
     * - 비밀번호 변경이 성공한 경우, {@code signIn} 메서드로 로그인되었는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("비밀번호 변경 성공 테스트 케이스")
    public void testChangePwSuccess() {
        boolean result = user.changePw("password123", "new");
        assertTrue(result, "비밀번호 변경 성공!");
        assertTrue(user.signIn("new"), "새 비밀번호 로그인 성공!");
    }

    /**
     * <b> 역할: {@link User#changePw(String, String)} 실패 메소드 </b>
     * <p>
     * - 비밀번호 변경이 실패한 경우, {@code changePw} 메서드가 {@code false} 반환하는지 확인 <br>
     * - 비밀번호 변경이 실패한 경우, {@code signIn} 메서드로 로그인 실패하는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("기존 비밀번호가 틀려서, 비밀번호 변경 실패 테스트 케이스")
    public void testChangePwFailure() {
        boolean result = user.changePw("password", "new");
        assertFalse(result, "비밀번호 변경 실패!");
        assertFalse(user.signIn("new"), "새 비밀번호 로그인 실패!");
    }
}
