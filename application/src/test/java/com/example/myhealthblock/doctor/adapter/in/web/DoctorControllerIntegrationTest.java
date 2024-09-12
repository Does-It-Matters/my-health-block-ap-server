package com.example.myhealthblock.doctor.adapter.in.web;

import com.example.myhealthblock.doctor.adapter.in.web.request.DoctorSignUpRequest;
import com.example.myhealthblock.doctor.application.port.in.DoctorInputPort;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInputPortResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 테스트가 독립적으로 구성되지 않아서 연속적으로 실행하면 테스트 실패
// 독립적으로 각각 실행하면 테스트 성공
@SpringBootTest
@AutoConfigureMockMvc
class DoctorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DoctorInputPort doctorInputPort;

    @Autowired
    private ObjectMapper objectMapper;

    private DoctorSignUpRequest signUpRequest;
    private DoctorProfileInputPortResponse profileResponse;

    @BeforeEach
    void setUp() {
        signUpRequest = new DoctorSignUpRequest();
        signUpRequest.setId("doctor123");
        signUpRequest.setPw("pw");
        signUpRequest.setRole("DOCTOR");
        signUpRequest.setName("name");
        signUpRequest.setField("field");
        signUpRequest.setHospital("hospital");
        signUpRequest.setIntroduction("introduction");
    }

    @Test
    @DisplayName("의료진 회원가입 성공")
    void signUp_success() throws Exception {

        // When & Then
        mockMvc.perform(post("/api/v3/doctor/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUpRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    @DisplayName("중복 아이디 가입으로, 의료진 회원가입 실패")
    void signUp_fail() throws Exception {
        doctorInputPort.signUp(signUpRequest.toInputPortDTO());

        // When & Then
        mockMvc.perform(post("/api/v3/doctor/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUpRequest)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("의료진 프로필 조회 성공")
    void getDoctorProfile_success() throws Exception {
        // 사전 작업: 의료진 프로필을 반환하도록 설정
        doctorInputPort.signUp(signUpRequest.toInputPortDTO());

        // When & Then
        mockMvc.perform(get("/api/v3/doctor/{doctorId}", "doctor123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.field").value("field"))
                .andExpect(jsonPath("$.hospital").value("hospital"))
                .andExpect(jsonPath("$.introduction").value("introduction"));
    }
}