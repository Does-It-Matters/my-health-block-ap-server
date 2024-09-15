package com.example.myhealthblock.patient.adapter.out.database.mongodb;

import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Component
public class PatientPersistenceAdapter implements PatientOutputPort {
    private final PatientRepository patientRepository;

    @Override
    public boolean create(String id) {
        PatientDocument p = new PatientDocument(id);
        patientRepository.save(p);
        return true;
    }
}