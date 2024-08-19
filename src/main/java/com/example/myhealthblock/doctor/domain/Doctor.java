package com.example.myhealthblock.doctor.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Doctor {
    private String id;
    private String name;
    private String field;
    private String hospital;
    private String introduction;

    public void updateProfile(String name, String field, String hospital, String introduction) {
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
    }
}
