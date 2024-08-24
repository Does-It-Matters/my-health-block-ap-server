package com.example.myhealthblock.patient.application.port.in.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientSignUpInputPortRequest {
    String id;
    String pw;
    String role;
}
