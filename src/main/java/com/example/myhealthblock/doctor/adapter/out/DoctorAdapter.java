package com.example.myhealthblock.doctor.adapter.out;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.doctor.DoctorOutport;
import com.example.myhealthblock.doctor.dto.DoctorProfileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class DoctorAdapter implements DoctorOutport {
    private final DoctorRepository doctorRepository;

    @Override
    public boolean create(String id, String name, String field, String hospital, String introduction) {
        DoctorEntity q = new DoctorEntity(id, name, field, hospital, introduction);
        this.doctorRepository.save(q);

        return true;
    }

    @Override
    public DoctorProfileDTO getDoctorProfile(String doctorId) {
        DoctorEntity doctor = getDoctorEntity(doctorId);

        return new DoctorProfileDTO(doctor.getName(), doctor.getField(), doctor.getHospital(), doctor.getIntroduction());
    }

    private DoctorEntity getDoctorEntity(String doctorId) {
        return this.doctorRepository.findByUserId(doctorId);
    }
}
