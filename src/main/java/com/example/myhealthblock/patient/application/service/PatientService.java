package com.example.myhealthblock.patient.application.service;

import com.example.myhealthblock.patient.adapter.in.web.request.PatientSignUpRequest;
import com.example.myhealthblock.patient.application.port.in.PatientInport;
import com.example.myhealthblock.patient.application.port.out.PatientOutport;
import com.example.myhealthblock.patient.domain.dto.PatientEntityDTO;
import com.example.myhealthblock.user.application.port.in.UserSignUp;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientService implements PatientInport {
    private final PatientOutport outport;
    private final UserSignUp userInport;

    @Override
    public boolean signUp(PatientSignUpRequest dto){
        UserSignUpRequest user = new UserSignUpRequest();
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
