package com.example.myhealthblock.patient.application.service;

import com.example.myhealthblock.patient.adapter.in.web.request.RequestPatientSignUp;
import com.example.myhealthblock.patient.application.port.in.GetPatientEntityDTO;
import com.example.myhealthblock.patient.application.port.out.PatientOutport;
import com.example.myhealthblock.patient.domain.dto.PatientEntityDTO;
import com.example.myhealthblock.user.application.port.in.UserSignUp;
import com.example.myhealthblock.user.adapter.in.web.request.RequestUserSignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientService implements GetPatientEntityDTO {
    private final PatientOutport outport;
    private final UserSignUp userInport;

    public boolean signUp(RequestPatientSignUp dto){
        RequestUserSignUp user = new RequestUserSignUp();
        user.setId(dto.getId());
        user.setPw(dto.getPw());
        user.setRole(dto.getRole());

        if (userInport.signUp(user)){
            return outport.create(dto.getId());
        }
        return false;
    }

    @Override
    public PatientEntityDTO getPatientEntityDTO(String uid) {
        return outport.getUserEntityDTO(uid);
    }
}