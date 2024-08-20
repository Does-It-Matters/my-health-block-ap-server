package com.example.myhealthblock.patient.application.port.out;


import com.example.myhealthblock.patient.domain.dto.PatientEntityDTO;

public interface PatientOutport {
    public boolean create(String id);
    public PatientEntityDTO getUserEntityDTO(String id);
}
