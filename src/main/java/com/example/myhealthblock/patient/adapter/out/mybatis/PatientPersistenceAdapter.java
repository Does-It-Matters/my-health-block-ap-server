package com.example.myhealthblock.patient.adapter.out.mybatis;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class PatientPersistenceAdapter implements PatientOutputPort {
    private final PatientMapper patientMapper;

    @Override
    public boolean create(String id) {
        PatientEntity p = new PatientEntity(id);
        patientMapper.insertPatient(p);
        return true;
    }
}