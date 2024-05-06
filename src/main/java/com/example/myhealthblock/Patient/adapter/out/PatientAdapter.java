package com.example.myhealthblock.patient.adapter.out;

import com.example.myhealthblock.patient.PatientOutport;
import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientAdapter implements PatientOutport {
    private final PatientRepository patientRepository;
    @Override
    public boolean create(String id) {
        PatientEntity p = new PatientEntity(id);
        this.patientRepository.save(p);

        return true;
    }

    @Override
    public PatientEntityDTO getUserEntityDTO(String id) {
        return new PatientEntityDTO(getPatientEntity(id));
    }

    @Override
    public boolean enrollUrgentData(String id, String content) {
        PatientEntity patient = getPatientEntity(id);
        patient.setUrgentData(content);
        this.patientRepository.save(patient);
        return true;
    }

    private PatientEntity getPatientEntity(String id) {
        return this.patientRepository.findByUserId(id);
    }
}
