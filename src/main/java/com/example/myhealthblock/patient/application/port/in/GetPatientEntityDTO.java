package com.example.myhealthblock.patient.application.port.in;

import com.example.myhealthblock.patient.domain.dto.PatientEntityDTO;

public interface GetPatientEntityDTO {
    public PatientEntityDTO getPatientEntityDTO(String uid);
}
