package com.example.myhealthblock.doctor.application.port.in.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorSignUpInportResponse {
    private String id;
    private String name;
    private String field;
    private String hospital;
    private String introduction;
    private String result;
}