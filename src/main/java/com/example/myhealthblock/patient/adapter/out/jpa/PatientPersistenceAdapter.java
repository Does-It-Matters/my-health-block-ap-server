package com.example.myhealthblock.patient.adapter.out.jpa;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import lombok.RequiredArgsConstructor;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
public class PatientPersistenceAdapter implements PatientOutputPort {
    private final PatientRepository patientRepository;

    @Override
    public boolean create(String id) {
        PatientEntity p = new PatientEntity(id);
        this.patientRepository.save(p);

        return true;
    }
}