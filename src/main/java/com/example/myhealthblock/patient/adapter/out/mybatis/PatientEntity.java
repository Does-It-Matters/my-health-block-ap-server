package com.example.myhealthblock.patient.adapter.out.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PatientEntity {

    private Integer id;
    private String userId;
    private String urgentData;
    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;

    public PatientEntity() {}

    public PatientEntity(String userId) {
        this.userId = userId;
        this.createDate = LocalDateTime.now();
        this.lastEditDate = LocalDateTime.now();
    }
}