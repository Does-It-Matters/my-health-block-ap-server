package com.example.myhealthblock.doctor.application.port.in;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportDTO;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutportDTO;

public interface DoctorSignUp {
    DoctorSignUpOutportDTO signUp(DoctorSignUpInportDTO dto);
}
