//package com.example.myhealthblock.patient.adapter.in.web;
//
//import com.example.myhealthblock.aop.LogExecutionTime;
//import com.example.myhealthblock.aop.LogTarget;
//import com.example.myhealthblock.patient.application.port.in.PatientInport;
//import com.example.myhealthblock.patient.adapter.in.web.request.*;
//import com.example.myhealthblock.patient.adapter.in.web.response.ResultResponse;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@Tag(name = "Patient", description = "Endpoints for Patient")
//@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api")
//public class PatientController {
//    private final PatientInport patientService;
//
//    @Operation(summary = "환자 회원가입", description = "아이디, 패스워드 등록")
//    @PostMapping("/v2/patient/sign-up")
//    public ResponseEntity<ResultResponse> signUp(@RequestBody PatientSignUpRequest body){
//        patientService.signUp(body);
//        ResultResponse response = new ResultResponse();
//        response.setResult("success");
//        return ResponseEntity.ok(response);
//    }
//}
