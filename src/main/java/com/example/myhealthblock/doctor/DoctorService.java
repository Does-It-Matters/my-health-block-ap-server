package com.example.myhealthblock.doctor;

import com.example.myhealthblock.doctor.adapter.in.request.RequestDoctorSignUp;
import com.example.myhealthblock.doctor.domain.Doctor;
import com.example.myhealthblock.doctor.dto.DoctorProfileDTO;
import com.example.myhealthblock.doctor.dto.DoctorSignUpRequestDTO;
import com.example.myhealthblock.doctor.dto.DoctorSignUpResponseDTO;
import com.example.myhealthblock.doctor.mapper.DoctorMapper;
import com.example.myhealthblock.user.UserSignUp;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignUp;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 의료진 회원 관리 비즈니스 로직을 처리하는 서비스 클래스 </b>
 * <br>- 의료진 회원 관리
 */
@RequiredArgsConstructor
@Service
public class DoctorService {
    private final DoctorOutport outport;
    private final UserSignUp userInport;
    private final DoctorMapper mapper = DoctorMapper.INSTANCE;

    public DoctorSignUpResponseDTO signUp(DoctorSignUpRequestDTO dto) {
        RequestUserSignUp userSignUp = new RequestUserSignUp();
        userSignUp.setId(dto.getId());
        userSignUp.setPw(dto.getPw());
        userSignUp.setRole("DOCTOR");

        if (userInport.signUp(userSignUp)) {
            Doctor doctor = mapper.dtoToDoctor(dto);
            outport.create(doctor);

            return mapper.doctorToDto(doctor, "success");
        } else {
            DoctorSignUpResponseDTO responseDTO = new DoctorSignUpResponseDTO();
            responseDTO.setResult("failure");
            return responseDTO;
        }
    }

    /**
     * <b> 역할: 의료진 회원가입 메소드 </b>
     * <br>- 최소한의 사용자 회원가입을 먼저 저장 시도
     * <br>- 의료진 정보 저장
     *
     * @param dto 의료진 회원가입 요청 데이터
     * @return 회원가입 성공 여부
     */
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

    /**
     * <b> 역할: 의료진 프로필 조회 메소드 </b>
     * <br>- 의료진 ID로 프로필 조회
     *
     * @param doctorId 의료진 ID
     * @return 의료진 프로필 데이터
     */
    public DoctorProfileDTO getDoctorProfile(String doctorId) {
        return outport.getDoctorProfile(doctorId);
    }
}
