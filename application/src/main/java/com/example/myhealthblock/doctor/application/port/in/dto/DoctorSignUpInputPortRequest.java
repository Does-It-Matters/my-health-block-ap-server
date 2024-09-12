package com.example.myhealthblock.doctor.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSignUpInputPortRequest {
    private String id;
    private String pw;
    private String role;
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}