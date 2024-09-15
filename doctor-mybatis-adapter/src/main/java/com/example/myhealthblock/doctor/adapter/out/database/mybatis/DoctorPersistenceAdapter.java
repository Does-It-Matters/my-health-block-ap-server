package com.example.myhealthblock.doctor.adapter.out.database.mybatis;

import com.example.myhealthblock.doctor.application.port.out.DoctorOutputPort;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorProfileOutputPortResponse;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutputPortRequest;
import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 의료진 데이터 처리하는 어댑터 클래스 </b>
 * <br>- DoctorMapper를 통해 데이터베이스와 상호작용
 *
 * @see DoctorMapper
 */
//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
public class DoctorPersistenceAdapter implements DoctorOutputPort {
    private final DoctorMapper doctorMapper;

    /**
     * <b> 역할: 의료진 데이터 저장하는 메소드 </b>
     *
     * @param doctor 저장할 의료진 정보
     * @return 저장 성공 여부
     */
    @Override
    public boolean create(DoctorSignUpOutputPortRequest doctor) {
        DoctorEntity q = new DoctorEntity(doctor.getId(), doctor.getName(), doctor.getField(), doctor.getHospital(), doctor.getIntroduction());
        this.doctorMapper.insertDoctor(q);

        return true;
    }

    /**
     * <b> 역할: 의료진 프로필 조회하는 메소드 </b>
     *
     * @param doctorId 의료진 ID
     * @return 의료진 프로필 정보
     */
    @Override
    public DoctorProfileOutputPortResponse getDoctorProfile(String doctorId) {
        DoctorEntity doctor = getDoctorEntity(doctorId);

        return new DoctorProfileOutputPortResponse(doctor.getName(), doctor.getField(), doctor.getHospital(), doctor.getIntroduction());
    }

    /**
     * <b> 역할: 의료진 ID로 DoctorEntity를 조회하는 메소드 </b>
     *
     * @param doctorId 의료진 ID
     * @return 조회된 DoctorEntity
     */
    private DoctorEntity getDoctorEntity(String doctorId) {
        return this.doctorMapper.selectDoctorByUserId(doctorId);
    }
}