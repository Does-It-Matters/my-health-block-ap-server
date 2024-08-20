package com.example.myhealthblock.doctor.application.service;

import com.example.myhealthblock.doctor.application.port.out.DoctorOutport;
import com.example.myhealthblock.doctor.domain.dto.DoctorProfileDTO;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportDTO;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutportDTO;
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
        DoctorSignUpInportDTO requestDTO = new DoctorSignUpInportDTO();
        requestDTO.setId("id");
        requestDTO.setPw("pw");

        when(userSignUp.signUp(any())).thenReturn(false);

        DoctorSignUpOutportDTO responseDTO = doctorService.signUp(requestDTO);

        assertEquals("failure", responseDTO.getResult());
    }

    @Test
    public void testGetDoctorProfile() {
        DoctorProfileDTO profileDTO = new DoctorProfileDTO("name", "field", "hospital", "introduction");
        when(doctorOutport.getDoctorProfile("id")).thenReturn(profileDTO);

        DoctorProfileDTO result = doctorService.getDoctorProfile("id");

        assertEquals("name", result.getName());
        assertEquals("field", result.getField());
        assertEquals("hospital", result.getHospital());
        assertEquals("introduction", result.getIntroduction());
    }
}
