package com.example.myhealthblock.patient.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientSignUpInputPortRequest {
    String id;
    String pw;
    String role;
}
