package com.example.myhealthblock.patient.adapter.in.web;

import com.example.myhealthblock.patient.adapter.in.web.request.PatientSignUpRequest;
import com.example.myhealthblock.patient.application.port.in.PatientInputPort;
import com.example.myhealthblock.patient.adapter.out.jpa.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PatientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PatientInputPort patientInputPort;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PatientRepository patientRepository;

    private PatientSignUpRequest signUpRequest;

    @BeforeEach
    void setUp() {
        signUpRequest = new PatientSignUpRequest();
        signUpRequest.setId("patient123");
        signUpRequest.setPw("pw");
        signUpRequest.setRole("PATIENT");
    }

    @Test
    @DisplayName("환자 회원가입 성공")
    void signUp_success() throws Exception {
        mockMvc.perform(post("/api/v3/patient/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUpRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    @DisplayName("중복 아이디로, 환자 회원가입 실패")
    void signUp_fail() throws Exception {
        // 사전 작업: 중복된 아이디로 환자 등록
        patientInputPort.signUp(signUpRequest.toInputPortDTO());

        mockMvc.perform(post("/api/v3/patient/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUpRequest)))
                .andExpect(status().is4xxClientError());
    }
}