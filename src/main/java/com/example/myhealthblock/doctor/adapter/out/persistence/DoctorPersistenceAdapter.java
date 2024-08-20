package com.example.myhealthblock.doctor.adapter.out.persistence;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutport;
import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.domain.dto.DoctorProfileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <b> 역할: 의료진 데이터 처리하는 어댑터 클래스 </b>
 * <br>- DoctorRepository를 통해 데이터베이스와 상호작용
 *
 * @see DoctorRepository
 */
@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class DoctorPersistenceAdapter implements DoctorOutport {
    private final DoctorRepository doctorRepository;

    @Override
    public boolean create(Doctor doctor) {
        return false;
    }

    /**
     * <b> 역할: 의료진 프로필 조회하는 메소드 </b>
     *
     * @param doctorId 의료진 ID
     * @return 의료진 프로필 정보
     */
    @Override
    public DoctorProfileDTO getDoctorProfile(String doctorId) {
        DoctorEntity doctor = getDoctorEntity(doctorId);

        return new DoctorProfileDTO(doctor.getName(), doctor.getField(), doctor.getHospital(), doctor.getIntroduction());
    }

    /**
     * <b> 역할: 의료진 ID로 DoctorEntity를 조회하는 메소드 </b>
     *
     * @param doctorId 의료진 ID
     * @return 조회된 DoctorEntity
     */
    private DoctorEntity getDoctorEntity(String doctorId) {
        return this.doctorRepository.findByUserId(doctorId);
    }
}
