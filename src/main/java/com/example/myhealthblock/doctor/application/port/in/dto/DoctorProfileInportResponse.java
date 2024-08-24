package com.example.myhealthblock.doctor.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoctorProfileInportResponse {
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}
