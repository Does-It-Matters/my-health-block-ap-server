package com.example.myhealthblock.user.application.service;

import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortResponse;
import com.example.myhealthblock.user.application.port.in.dto.UserSignUpInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserUpdatePwInputPortRequest;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import com.example.myhealthblock.user.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> 역할: {@link UserService} 통합 테스트 클래스 </b>
 * <p>
 * - 실제 데이터베이스와의 상호작용을 검증하기 위한 통합 테스트 <br>
 * - 사용자 가입, 로그인, 비밀번호 변경 등의 기능을 검증 <br>
 * </p>
 */
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOutputPort userOutputPort;

    /**
     * <b> 역할: 각 테스트 전에 데이터베이스를 초기화하는 메서드 </b>
     * <p>
     * - 테스트가 시작되기 전에 데이터베이스를 초기 상태로 만듭니다. <br>
     * </p>
     */
    @BeforeEach
    public void setUp() {
    }

    /**
     * <b> 역할: 사용자 가입 통합 테스트 </b>
     * <p>
     * - 사용자를 가입시키고 데이터베이스에 제대로 저장되었는지 검증합니다. <br>
     * </p>
     */
    @Test
    @DisplayName("회원가입 통합 테스트")
    public void testSignUpIntegration() {
        // Given
        String id = "integrationUser";
        UserSignUpInputPortRequest signUpRequest = new UserSignUpInputPortRequest();
        signUpRequest.setId(id);
        signUpRequest.setPw("password123");
        signUpRequest.setRole("USER");

        // When
        boolean result = userService.signUp(signUpRequest);

        // Then
        assertTrue(result, "회원가입 성공");
        User createdUser = userOutputPort.getUser(id);
        assertNotNull(createdUser, "사용자 조회 성공");
        assertEquals("USER", createdUser.getRole(), "사용자 역할 확인");
    }

    /**
     * <b> 역할: 로그인 통합 테스트 </b>
     * <p>
     * - 사용자가 로그인을 시도하고 로그인 결과를 검증합니다. <br>
     * </p>
     */
    @Test
    @DisplayName("로그인 통합 테스트")
    public void testSignInIntegration() {
        // Given
        String id = "integrationUser";
        UserSignInInputPortRequest signInRequest = new UserSignInInputPortRequest(id, "password123");

        UserSignUpInputPortRequest signUpRequest = new UserSignUpInputPortRequest();
        signUpRequest.setId(id);
        signUpRequest.setPw("password123");
        signUpRequest.setRole("USER");
        userService.signUp(signUpRequest);

        // When
        UserSignInInputPortResponse response = userService.signIn(signInRequest);

        // Then
        assertNotNull(response, "로그인 성공");
        assertEquals("USER", response.getRole(), "역할 확인");
        assertEquals(id, response.getId(), "사용자 ID 확인");
    }

    /**
     * <b> 역할: 비밀번호 변경 통합 테스트 </b>
     * <p>
     * - 사용자의 비밀번호를 변경하고 그 결과를 검증합니다. <br>
     * </p>
     */
    @Test
    @DisplayName("비밀번호 변경 통합 테스트")
    public void testChangePwIntegration() {
        // Given
        String id = "integrationUser";
        String oldPw = "password123";
        String newPw = "newPassword123";

        UserSignUpInputPortRequest signUpRequest = new UserSignUpInputPortRequest();
        signUpRequest.setId(id);
        signUpRequest.setPw(oldPw);
        signUpRequest.setRole("USER");
        userService.signUp(signUpRequest);

        UserUpdatePwInputPortRequest changePwRequest = new UserUpdatePwInputPortRequest(oldPw, newPw);

        // When
        String result = userService.changePw(id, changePwRequest);

        // Then
        assertEquals("success", result, "비밀번호 변경 성공");
        User user = userOutputPort.getUser(id);
        assertTrue(user.signIn(newPw), "새 비밀번호로 로그인 성공");
    }
}