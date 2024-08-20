package com.example.myhealthblock.doctor.adapter.in.web;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInportResponse;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportRequest;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportResponse;
import com.example.myhealthblock.doctor.application.service.DoctorService;
import com.example.myhealthblock.doctor.adapter.in.web.request.DoctorSignUpRequest;
import com.example.myhealthblock.doctor.adapter.in.web.response.DoctorDataResponse;
import com.example.myhealthblock.doctor.adapter.in.web.response.SignUpResultResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutportResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DoctorControllerTest {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private DoctorService doctorService;

    public DoctorControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignUpSuccess() {
        DoctorSignUpInportRequest request = new DoctorSignUpInportRequest();
        request.setId("id");
        request.setPw("pw");
        request.setRole("DOCTOR");
        request.setName("name");
        request.setField("field");
        request.setHospital("hospital");
        request.setIntroduction("introduction");

        // 임시 진행: null
        when(doctorService.signUp(request)).thenReturn(null);

        // 임시 진행: new DoctorSignUpRequest()
        ResponseEntity<SignUpResultResponse> response = doctorController.signUp(new DoctorSignUpRequest());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody().getResult());
    }

    @Test
    public void testSignUpConflict() {
        DoctorSignUpInportRequest request = new DoctorSignUpInportRequest();
        request.setId("id");
        request.setPw("pw");

        // 임시 진행: null
        when(doctorService.signUp(request)).thenReturn(null);

        // 임시 진행: new DoctorSignUpRequest()
        ResponseEntity<SignUpResultResponse> response = doctorController.signUp(new DoctorSignUpRequest());

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("confilct: A user with this ID already exists.", response.getBody().getResult());
    }

    @Test
    public void testGetDoctorProfile() {
        String doctorId = "id";
        DoctorProfileOutportResponse profileDTO = new DoctorProfileOutportResponse("name", "field", "hospital", "introduction");
        // 임시 진행: new DoctorProfileInportResponse(profileDTO.getName(), profileDTO.getField(), profileDTO.getHospital(), profileDTO.getIntroduction())
        when(doctorService.getDoctorProfile(doctorId)).thenReturn(new DoctorProfileInportResponse(profileDTO.getName(), profileDTO.getField(), profileDTO.getHospital(), profileDTO.getIntroduction()));

        ResponseEntity<DoctorDataResponse> response = doctorController.get(doctorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        DoctorDataResponse responseBody = response.getBody();

        assertNotNull(responseBody);
        assertEquals("name", responseBody.getName());
        assertEquals("field", responseBody.getField());
        assertEquals("hospital", responseBody.getHospital());
        assertEquals("introduction", responseBody.getIntroduction());
    }
}