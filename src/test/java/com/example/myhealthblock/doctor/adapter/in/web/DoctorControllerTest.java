package com.example.myhealthblock.doctor.adapter.in.web;

import com.example.myhealthblock.doctor.application.service.DoctorService;
import com.example.myhealthblock.doctor.adapter.in.web.request.DoctorSignUpRequest;
import com.example.myhealthblock.doctor.adapter.in.web.response.DoctorDataResponse;
import com.example.myhealthblock.doctor.adapter.in.web.response.SignUpResultResponse;
import com.example.myhealthblock.doctor.domain.dto.DoctorProfileDTO;
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
        DoctorSignUpRequest request = new DoctorSignUpRequest();
        request.setId("id");
        request.setPw("pw");
        request.setRole("DOCTOR");
        request.setName("name");
        request.setField("field");
        request.setHospital("hospital");
        request.setIntroduction("introduction");

        when(doctorService.signUp(request)).thenReturn(true);

        ResponseEntity<SignUpResultResponse> response = doctorController.signUp(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody().getResult());
    }

    @Test
    public void testSignUpConflict() {
        DoctorSignUpRequest request = new DoctorSignUpRequest();
        request.setId("id");
        request.setPw("pw");

        when(doctorService.signUp(request)).thenReturn(false);

        ResponseEntity<SignUpResultResponse> response = doctorController.signUp(request);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("confilct: A user with this ID already exists.", response.getBody().getResult());
    }

    @Test
    public void testGetDoctorProfile() {
        String doctorId = "id";
        DoctorProfileDTO profileDTO = new DoctorProfileDTO("name", "field", "hospital", "introduction");
        when(doctorService.getDoctorProfile(doctorId)).thenReturn(profileDTO);

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