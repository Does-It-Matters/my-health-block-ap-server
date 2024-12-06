package com.example.myhealthblock.doctor.application.port.in;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInputPortRequest;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInputPortResponse;

public interface DoctorSignUp {
    DoctorSignUpInputPortResponse signUp(DoctorSignUpInputPortRequest dto);
}
