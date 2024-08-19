package com.example.myhealthblock.doctor.application.port.in;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpDTO;

public interface DoctorSignUp {
    boolean signUp(DoctorSignUpDTO dto);
}
