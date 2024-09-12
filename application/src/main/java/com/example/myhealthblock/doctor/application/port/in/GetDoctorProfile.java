package com.example.myhealthblock.doctor.application.port.in;


import com.example.myhealthblock.doctor.application.port.in.dto.DoctorProfileInputPortResponse;

public interface GetDoctorProfile {
    DoctorProfileInputPortResponse getDoctorProfile(String doctorId);
}
