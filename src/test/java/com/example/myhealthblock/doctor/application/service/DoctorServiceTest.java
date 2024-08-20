package com.example.myhealthblock.doctor.application.service;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInportResponse;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutport;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutportResponse;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportRequest;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportResponse;
import com.example.myhealthblock.doctor.domain.mapper.DoctorMapper;
import com.example.myhealthblock.user.application.port.in.UserSignUp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DoctorServiceTest {

    @InjectMocks
    private DoctorService doctorService;

    @Mock
    private DoctorOutport doctorOutport;

    @Mock
    private UserSignUp userSignUp;

    @Mock
    private DoctorMapper doctorMapper;

    public DoctorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testSignUpSuccess() {
//        DoctorSignUpRequestDTO requestDTO = new DoctorSignUpRequestDTO();
//        requestDTO.setId("id");
//        requestDTO.setPw("pw");
//        requestDTO.setName("name");
//        requestDTO.setField("field");
//        requestDTO.setHospital("hospital");
//        requestDTO.setIntroduction("introduction");
//
//        when(userSignUp.signUp(any())).thenReturn(true);
//        when(doctorMapper.dtoToDoctor(any())).thenReturn(new Doctor("id", "name", "field", "hospital", "introduction"));
//        when(doctorOutport.create(any())).thenReturn(true);
//        when(doctorMapper.doctorToDto(any(), anyString())).thenReturn(new DoctorSignUpResponseDTO());
//
//        DoctorSignUpResponseDTO responseDTO = doctorService.signUp(requestDTO);
//
//        assertEquals("success", responseDTO.getResult());
//    }

    @Test
    public void testSignUpFailure() {
        DoctorSignUpInportRequest requestDTO = new DoctorSignUpInportRequest();
        requestDTO.setId("id");
        requestDTO.setPw("pw");

        when(userSignUp.signUp(any())).thenReturn(false);

        DoctorSignUpInportResponse responseDTO = doctorService.signUp(requestDTO);

        assertEquals("failure", responseDTO.getResult());
    }

    @Test
    public void testGetDoctorProfile() {
        DoctorProfileOutportResponse profileDTO = new DoctorProfileOutportResponse("name", "field", "hospital", "introduction");
        when(doctorOutport.getDoctorProfile("id")).thenReturn(profileDTO);

        DoctorProfileInportResponse result = doctorService.getDoctorProfile("id");

        assertEquals("name", result.getName());
        assertEquals("field", result.getField());
        assertEquals("hospital", result.getHospital());
        assertEquals("introduction", result.getIntroduction());
    }
}
