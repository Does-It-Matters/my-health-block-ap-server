package com.example.myhealthblock.patient.domain.dto;

import com.example.myhealthblock.patient.adapter.out.persistence.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatientEntityDTO {
    PatientEntity entity;
}
