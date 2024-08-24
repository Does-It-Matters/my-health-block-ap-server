package com.example.myhealthblock.patient.application.port.in;

import com.example.myhealthblock.patient.application.port.in.dto.PatientSignUpInputPortRequest;

public interface PatientSignUp {
    boolean signUp(PatientSignUpInputPortRequest dto);
}
