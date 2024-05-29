package com.example.myhealthblock.doctor.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.doctor.DoctorService;
import com.example.myhealthblock.doctor.adapter.in.request.RequestDoctorSignUp;
import com.example.myhealthblock.doctor.adapter.in.request.RequestPatientUrgentData;
import com.example.myhealthblock.doctor.adapter.in.response.ResponseDoctorData;
import com.example.myhealthblock.doctor.adapter.in.response.ResponsePatientUrgentData;
import com.example.myhealthblock.doctor.adapter.in.response.ResponseResult;
import com.example.myhealthblock.doctor.dto.DoctorProfileDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Tag(name = "Doctor", description = "Endpoints for doctor")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DoctorController {
    private final DoctorService doctorService;

    @Operation(summary = "의사 회원가입", description = "아이디와 패스워드, 추가 데이터로 회원가입")
    @PostMapping("/v1/doctor/sign-up")
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

    @Operation(summary = "의사 - 환자 긴급 데이터 열람", description = "열람 이유 입력")
    @PostMapping("/v1/doctor/get-patient-urgent-data")
    public ResponseEntity<ResponsePatientUrgentData> getPatientUrgentData(@RequestBody RequestPatientUrgentData body) {
        ResponsePatientUrgentData response = new ResponsePatientUrgentData();
        response.setPatientUrgentData(doctorService.getPatientUrgentData(body));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "저장된 개인정보 삭제", description = "회원 탈퇴 기능이 아닌 저장된 정보를 삭제 <br>{doctorId}는 의료진이 가입한 아이디")
    @DeleteMapping({"/v1/doctor/{doctorId}", "/test-0/doctor/{doctorId}"})
    public ResponseEntity<ResponseResult> delete(@PathVariable String doctorId) {
        return ResponseEntity.ok(new ResponseResult(doctorService.deleteData(doctorId)));
    }

    @Operation(summary = "의료진 프로필 조회", description = "의료진의 데이터 중 공개용 데이터 조회 <br>{doctorId}는 의료진이 가입한 아이디")
    @GetMapping({"/v1/doctor/{doctorId}", "/test-0/doctor/{doctorId}"})
    public ResponseEntity<ResponseDoctorData> get(@PathVariable String doctorId) {
        DoctorProfileDTO profile = doctorService.getDoctorProfile(doctorId);
        return ResponseEntity.ok(new ResponseDoctorData(profile.getName(), profile.getField(), profile.getHospital(), profile.getIntroduction()));
    }
}
