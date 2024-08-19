package com.example.myhealthblock.doctor.application.port.in;


import com.example.myhealthblock.doctor.domain.dto.DoctorProfileDTO;

public interface GetDoctorProfile {
    DoctorProfileDTO getDoctorProfile(String doctorId);
}
