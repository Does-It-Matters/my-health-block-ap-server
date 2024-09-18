package com.example.myhealthblock.patient.adapter.out.database.mybatis;

import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Component
public class PatientPersistenceAdapter implements PatientOutputPort {
    private final PatientMapper patientMapper;

    @Override
    public boolean create(String id) {
        PatientEntity p = new PatientEntity(id);
        patientMapper.insertPatient(p);
        return true;
    }
}