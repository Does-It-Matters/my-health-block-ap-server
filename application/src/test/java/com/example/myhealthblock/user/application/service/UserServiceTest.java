package com.example.myhealthblock.user.application.service;

import com.example.myhealthblock.user.application.port.in.dto.*;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import com.example.myhealthblock.user.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> 역할: {@link UserService} 단위 테스트 클래스 </b>
 * <p>
 * - 모의 객체를 사용하여 {@link UserService}의 비즈니스 로직을 검증 <br>
 * - 사용자 가입, 로그인, 비밀번호 변경 등의 기능을 검증 <br>
 * </p>
 */
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserOutputPort userOutputPort;

    @Mock
    private User user; // User 객체를 Mock으로 사용

    /**
     * <b> 역할: 테스트 초기화 메소드 </b>
     * <p>
     * - 모의 객체를 초기화하여 테스트 준비 <br>
     * </p>
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * <b> 역할: 사용자 가입 성공 단위 테스트 </b>
     * <p>
     * - 새로운 사용자가 성공적으로 가입되는지 검증합니다. <br>
     * </p>
     */
    @Test
    @DisplayName("회원가입 성공 테스트")
    public void testSignUpSuccess() {
        // Given
        String id = "newUser";
        UserSignUpInputPortRequest signUpRequest = new UserSignUpInputPortRequestDTO();
        signUpRequest.setId(id);
        signUpRequest.setPw("password123");
        signUpRequest.setRole("USER");

        // Mock behavior 설정
        when(userOutputPort.getUser(id)).thenReturn(null);
        when(userOutputPort.create(id, "password123", "USER")).thenReturn(true);

        // When
        boolean result = userService.signUp(signUpRequest);

        // Then
        assertTrue(result, "회원가입 성공");
        verify(userOutputPort).create(id, "password123", "USER");
    }

    /**
     * <b> 역할: 이미 존재하는 사용자로 인한 가입 실패 단위 테스트 </b>
     * <p>
     * - 이미 존재하는 사용자 ID로 가입 시도 시 실패를 검증합니다. <br>
     * </p>
     */
    @Test
    @DisplayName("이미 존재하는 사용자로 인해 회원가입 실패 테스트")
    public void testSignUpFailure() {
        // Given
        String id = "existingUser";
        UserSignUpInputPortRequest signUpRequest = new UserSignUpInputPortRequestDTO();
        signUpRequest.setId(id);
        signUpRequest.setPw("password123");
        signUpRequest.setRole("USER");

        // Mock behavior 설정
        when(userOutputPort.getUser(id)).thenReturn(new User("1", id, "password123", "USER"));

        // When
        boolean result = userService.signUp(signUpRequest);

        // Then
        assertFalse(result, "이미 존재하는 사용자로 인해 회원가입 실패");
    }

    /**
     * <b> 역할: 로그인 성공 단위 테스트 </b>
     * <p>
     * - 사용자가 올바른 비밀번호로 로그인할 수 있는지 검증합니다. <br>
     * </p>
     */
    @Test
    @DisplayName("로그인 성공 테스트")
    public void testSignInSuccess() {
        // Given
        String id = "user123";
        UserSignInInputPortRequest signInRequest = new UserSignInInputPortRequestDTO(id, "password123");

        // Mock behavior 설정
        when(userOutputPort.getUser(id)).thenReturn(new User("1", id, "password123", "USER"));

        // When
        UserSignInInputPortResponse response = userService.signIn(signInRequest);

        // Then
        assertNotNull(response, "로그인 성공");
        assertEquals("USER", response.getRole(), "역할 확인");
    }

    /**
     * <b> 역할: 로그인 실패 단위 테스트 </b>
     * <p>
     * - 잘못된 비밀번호로 로그인 시도를 검증합니다. <br>
     * </p>
     */
    @Test
    @DisplayName("로그인 실패 테스트")
    public void testSignInFailure() {
        // Given
        String id = "user123";
        UserSignInInputPortRequest signInRequest = new UserSignInInputPortRequestDTO(id, "wrongPassword");

        // Mock behavior 설정
        when(userOutputPort.getUser(id)).thenReturn(new User("1", id, "password123", "USER"));

        // When
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.signIn(signInRequest));

        // Then
        assertNotNull(exception, "로그인 실패로 예외 발생");
    }
}