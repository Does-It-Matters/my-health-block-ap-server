//package com.example.myhealthblock.api.healthdata;
//
//import com.example.myhealthblock.api.healthdata.dto.request.*;
//import org.springframework.stereotype.Service;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Service
//public class ApiService {
//    private final ApiOutport apiOutport = new ApiAdapter();
//
//    public String requestMedicalHistory(MedicalHistoryFirstRequestDTO dto) {
//        return apiOutport.requestMedicalHistory(dto.getHashMap());
//    }
//
//    public String requestTreatmentInformation(TreatmentInfoFirstRequestDTO dto) {
//        return apiOutport.requestTreatmentInformation(dto.getHashMap());
//    }
//
//    public String requestHealthCheckupResult(HealthCheckupFirstRequestDTO dto) {
//        return apiOutport.requestHealthCheckupResult(dto.getHashMap());
//    }
//
//    public String requestCertificationMedicalHistory(MedicalHistorySecondRequestDTO dto) {
//        return apiOutport.requestCertificationMedicalHistory(dto.getHashMap());
//    }
//
//    public String requestCertificationTreatmentInformation(TreatmentInfoSecondRequestDTO dto) {
//        return apiOutport.requestCertificationTreatmentInformation(dto.getHashMap());
//    }
//
//    public String requestCertificationHealthCheckupResult(HealthCheckupSecondRequestDTO dto) {
//        return apiOutport.requestCertificationHealthCheckupResult(dto.getHashMap());
//    }
//}
