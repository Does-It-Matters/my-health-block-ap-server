package com.example.myhealthblock.patient.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.PatientService;
import com.example.myhealthblock.patient.adapter.in.request.*;
import com.example.myhealthblock.patient.adapter.in.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Patient", description = "Endpoints for Patient")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService patientService;

    @Operation(summary = "환자 회원가입", description = "아이디, 패스워드 등록")
    @PostMapping("/v2/patient/sign-up")
    public ResponseEntity<ResponseResult> signUp(@RequestBody RequestPatientSignUp body){
        ResponseResult response = new ResponseResult();
        try {
            if (patientService.signUp(body)) {
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
}
