package com.example.myhealthblock.patient.adapter.out.persistence;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.application.port.out.PatientOutport;
import com.example.myhealthblock.patient.domain.dto.PatientEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class PatientPersistenceAdapter implements PatientOutport {
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

    private PatientEntity getPatientEntity(String id) {
        return this.patientRepository.findByUserId(id);
    }
}
