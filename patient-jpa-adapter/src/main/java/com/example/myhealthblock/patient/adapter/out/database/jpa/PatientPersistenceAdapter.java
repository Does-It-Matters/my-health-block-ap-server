package com.example.myhealthblock.patient.adapter.out.database.jpa;

import com.example.myhealthblock.patient.application.port.out.PatientOutputPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 환자 영속성 어댑터 클래스 </b>
 * <p>
 * - 포트 및 어댑터 구조에서 출력 어댑터 역할 수행 <br>
 * - {@link PatientRepository}와 연동하여 데이터베이스 작업을 수행 <br>
 * - 환자 생성과 같은 환자 관리 기능을 제공 <br>
 * </p>
 */
//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Component
public class PatientPersistenceAdapter implements PatientOutputPort {
    private final PatientRepository patientRepository;

    /**
     * <b> 역할: 환자 생성 메소드 </b>
     * <p>
     * - 새로운 환자를 생성하여 데이터베이스에 저장 <br>
     * </p>
     *
     * @param id  생성할 환자의 ID
     * @return 환자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     */
    @Override
    public boolean create(String id) {
        PatientEntity p = new PatientEntity(id);
        this.patientRepository.save(p);

        return true;
    }
}
