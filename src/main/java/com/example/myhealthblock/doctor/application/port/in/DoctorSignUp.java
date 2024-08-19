package com.example.myhealthblock.doctor.application.port.in;

import com.example.myhealthblock.doctor.adapter.in.web.request.DoctorSignUpRequest;

public interface DoctorSignUp {
    boolean signUp(DoctorSignUpRequest dto);
}
