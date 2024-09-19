package com.example.myhealthblock.patient.adapter.out.network.user;

import com.example.myhealthblock.patient.application.port.out.UserSignUpOutputPort;
import com.example.myhealthblock.patient.application.port.out.dto.PatientSignUpOutputPortToUserRequest;
import com.example.myhealthblock.user.application.port.in.UserSignUp;
import com.example.myhealthblock.user.application.port.in.dto.UserSignUpInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserSignUpInputPortRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserSignUpPatientAdapter implements UserSignUpOutputPort {
    private final UserSignUp userInputPort;

    /**
     * <b> 역할: 사용자 생성 요청 메소드 </b>
     * <p>
     *
     * @param dto 사용자 생성에 필요한 정보를 가진 dto
     * @return 사용자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     * </p>
     */
    @Override
    public boolean signUp(PatientSignUpOutputPortToUserRequest dto) {
        return userInputPort.signUp(getRequest(dto));
    }

    private UserSignUpInputPortRequest getRequest(PatientSignUpOutputPortToUserRequest dto) {
        UserSignUpInputPortRequest request = new UserSignUpInputPortRequestDTO();
        request.setId(dto.getId());
        request.setPw(dto.getPw());
        request.setRole(dto.getRole());
        return request;
    }
}
