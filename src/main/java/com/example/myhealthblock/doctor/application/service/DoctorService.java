package com.example.myhealthblock.doctor.application.service;

import com.example.myhealthblock.doctor.application.port.in.DoctorInport;
import com.example.myhealthblock.doctor.application.port.out.DoctorOutport;
import com.example.myhealthblock.doctor.domain.model.Doctor;
import com.example.myhealthblock.doctor.domain.dto.DoctorProfileDTO;
import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInportDTO;
import com.example.myhealthblock.doctor.application.port.out.dto.DoctorSignUpOutportDTO;
import com.example.myhealthblock.doctor.domain.mapper.DoctorMapper;
import com.example.myhealthblock.exception.UserAlreadyExistsException;
import com.example.myhealthblock.user.application.port.in.UserSignUp;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 의료진 회원 관리 비즈니스 로직을 처리하는 서비스 클래스 </b>
 * <br>- 의료진 회원 관리
 */
@RequiredArgsConstructor
@Service
public class DoctorService implements DoctorInport {
    private final DoctorOutport outport;
    private final UserSignUp userInport;
    private final DoctorMapper mapper = DoctorMapper.INSTANCE;

    /**
     * <b> 역할: 의료진 회원가입 메소드 </b>
     * <br>- 최소한의 사용자 회원가입을 먼저 저장 시도
     * <br>- 의료진 정보 저장
     *
     * @param dto 의료진 회원가입 요청 데이터
     * @return 회원가입 성공 여부
     */
    @Override
    public DoctorSignUpOutportDTO signUp(DoctorSignUpInportDTO dto) {
        UserSignUpRequest userSignUpDTO = new UserSignUpRequest();
        userSignUpDTO.setId(dto.getId());
        userSignUpDTO.setPw(dto.getPw());
        userSignUpDTO.setRole(dto.getRole());

        if (!userInport.signUp(userSignUpDTO)) {
            throw new UserAlreadyExistsException("A user with this ID already exists.");
        }

        Doctor doctor = mapper.dtoToDoctor(dto);
        outport.create(doctor);

        return mapper.doctorToDto(doctor, "success");
    }

    /**
     * <b> 역할: 의료진 프로필 조회 메소드 </b>
     * <br>- 의료진 ID로 프로필 조회
     *
     * @param doctorId 의료진 ID
     * @return 의료진 프로필 데이터
     */
    @Override
    public DoctorProfileDTO getDoctorProfile(String doctorId) {
        return outport.getDoctorProfile(doctorId);
    }
}
