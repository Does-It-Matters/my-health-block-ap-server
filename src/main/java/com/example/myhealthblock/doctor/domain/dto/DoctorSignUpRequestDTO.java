package com.example.myhealthblock.doctor.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorSignUpRequestDTO {
    private String id;
    private String pw;
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}