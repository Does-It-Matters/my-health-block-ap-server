package com.example.myhealthblock.doctor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorSignUpRequestDTO {
    private String id;
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}