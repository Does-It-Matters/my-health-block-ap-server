package com.example.myhealthblock.patient;


import com.example.myhealthblock.patient.dto.PatientEntityDTO;

public interface PatientOutport {
    public boolean create(String id);
    public PatientEntityDTO getUserEntityDTO(String id);
}
