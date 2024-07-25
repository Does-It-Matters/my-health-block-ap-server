package com.example.myhealthblock.doctor;

import com.example.myhealthblock.doctor.adapter.in.request.RequestDoctorSignUp;
import com.example.myhealthblock.doctor.dto.DoctorProfileDTO;
import com.example.myhealthblock.user.UserSignUp;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignUp;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DoctorService {
    private final DoctorOutport outport;
    private final UserSignUp userInport;

    public boolean signUp(RequestDoctorSignUp dto) {
        RequestUserSignUp user = new RequestUserSignUp();
        user.setId(dto.getId());
        user.setPw(dto.getPw());
        user.setRole(dto.getRole());
        if (userInport.signUp(user)){
            return outport.create(dto.getId(), dto.getName(), dto.getField(), dto.getHospital(), dto.getIntroduction());
        }
        return false;
    }

    public DoctorProfileDTO getDoctorProfile(String doctorId) {
        return outport.getDoctorProfile(doctorId);
    }
}
