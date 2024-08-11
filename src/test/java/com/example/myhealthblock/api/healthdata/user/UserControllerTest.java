package com.example.myhealthblock.api.healthdata.user;

import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.adapter.in.UserController;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignIn;
import com.example.myhealthblock.user.adapter.in.response.ResponseSignIn;
import com.example.myhealthblock.user.dto.ResultSignIn;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSignIn_Success() throws Exception {
        // Given
        RequestUserSignIn signInRequest = new RequestUserSignIn();
        signInRequest.setId("user");
        signInRequest.setPw("password");

        ResponseSignIn signInResponse = new ResponseSignIn();
        signInResponse.setResult("success");
        signInResponse.setRole("PATIENT");
        signInResponse.setId("user");

        when(userService.signIn(any(RequestUserSignIn.class))).thenReturn(new ResultSignIn());
//        when(userService.signIn(any(RequestUserSignIn.class))).thenReturn(signInResponse);

        // When / Then
        mockMvc.perform(post("/api/v2/sign-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signInRequest)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("PATIENT"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("user"));
    }
}
