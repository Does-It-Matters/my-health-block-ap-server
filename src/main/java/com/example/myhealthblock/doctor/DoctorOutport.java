package com.example.myhealthblock.doctor;

import com.example.myhealthblock.doctor.dto.DoctorProfileDTO;
import com.example.myhealthblock.user.User;

public interface DoctorOutport {
    public boolean create(String id, String name, String field, String hospital, String introduction);
    public DoctorProfileDTO getDoctorProfile(String doctorId);
}
