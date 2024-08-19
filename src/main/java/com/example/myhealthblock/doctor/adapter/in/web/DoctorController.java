package com.example.myhealthblock.doctor.adapter.in.web;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.doctor.application.service.DoctorService;
import com.example.myhealthblock.doctor.adapter.in.web.request.RequestDoctorSignUp;
import com.example.myhealthblock.doctor.adapter.in.web.response.ResponseDoctorData;
import com.example.myhealthblock.doctor.adapter.in.web.response.ResponseResult;
import com.example.myhealthblock.doctor.domain.dto.DoctorProfileDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 의료진 관련 컨트롤러 </b>
 * <br>- 의료진 회원 정보 관리
 */
@Tag(name = "Doctor", description = "Endpoints for doctor")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DoctorController {
    private final DoctorService doctorService;

    /**
     * <b> 역할: 의료진 회원가입 메소드 </b>
     * <br>- 요청 바디에서 의료진 정보 받아 회원가입
     *
     * @param body 의료진 회원가입 요청 바디 데이터
     * @return 회원가입 응답
     */
    @Operation(summary = "의사 회원가입", description = "아이디와 패스워드, 추가 데이터로 회원가입")
    @PostMapping("/v2/doctor/sign-up")
    public ResponseEntity<ResponseResult> signUp(@RequestBody RequestDoctorSignUp body) {
        ResponseResult response = new ResponseResult();
        try {
            if (doctorService.signUp(body)){
                response.setResult("success");
                return ResponseEntity.ok(response);
            } else {
                response.setResult("confilct: A user with this ID already exists.");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }
        } catch (Exception e) {
            response.setResult("error: An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * <b> 역할: 의료진 프로필 조회 메소드 </b>
     * <br>- 요청 경로로부터 의사 ID를 받아 프로필 정보 반환
     *
     * @param doctorId path에 있는 의료진 ID
     * @return 의료진 프로필 데이터 응답
     */
    @Operation(summary = "의료진 프로필 조회", description = "의료진의 데이터 중 공개용 데이터 조회 <br>{doctorId}는 의료진이 가입한 아이디")
    @GetMapping("/v2/doctor/{doctorId}")
    public ResponseEntity<ResponseDoctorData> get(@PathVariable String doctorId) {
        DoctorProfileDTO profile = doctorService.getDoctorProfile(doctorId);
        return ResponseEntity.ok(new ResponseDoctorData(profile.getName(), profile.getField(), profile.getHospital(), profile.getIntroduction()));
    }
}
