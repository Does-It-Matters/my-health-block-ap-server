package com.example.myhealthblock.user.adapter.in.web;

import com.example.myhealthblock.user.application.port.in.UserInputPort;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortResponse;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignInRequest;
import com.example.myhealthblock.user.adapter.in.web.request.UserUpdatePwRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * <b> 역할: 사용자 컨트롤러 통합 테스트 클래스 </b>
 * <p>
 * - 실제 HTTP 요청에 대한 통합 테스트 <br>
 * - 로그인, 비밀번호 변경 등의 기능을 검증 <br>
 * </p>
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserInputPort userInputPort;

    /**
     * <b> 역할: 로그인 테스트 메소드 </b>
     * <p>
     * </p>
     */
    @Test
    public void testSignIn() throws Exception {
        // Given
        UserSignInRequest signInRequest = new UserSignInRequest("user123", "password123");
        UserSignInInputPortResponse signInResponse = new UserSignInInputPortResponse("USER", "user123");
        when(userInputPort.signIn(any())).thenReturn(signInResponse);

        // When & Then
        mockMvc.perform(post("/api/v3/sign-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"user123\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("user123"))
                .andExpect(jsonPath("$.role").value("USER"));
    }

    /**
     * <b> 역할: 비밀번호 수정 테스트 메소드 </b>
     * <p>
     * </p>
     */
    @Test
    public void testUpdatePw() throws Exception {
        // Given
        UserUpdatePwRequest updatePwRequest = new UserUpdatePwRequest("password123", "newPassword123");
        when(userInputPort.changePw(eq("user123"), any())).thenReturn("success");

        // When & Then
        mockMvc.perform(put("/api/v3/user/user123/pw")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"oldPassword\":\"password123\",\"newPassword\":\"newPassword123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }
}