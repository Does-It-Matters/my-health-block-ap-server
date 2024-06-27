//package com.example.myhealthblock.api.healthdata.specific;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.HashMap;
//
//@Getter
//@Setter
//public class RealApi implements Api{
//    private static final String MEDICAL_HISTORY = "/v1/kr/public/pp/nhis-lifetime-health/treatment-contents";
//    private static final String TREATMENT_INFORMATION = "/v1/kr/public/pp/nhis-treatment/information";
//    private static final String HEALTH_CHECKUP_RESULT = "/v1/kr/public/pp/nhis-health-checkup/result";
//    private EasyCodef codef;
//
//    public RealApi() {
//        codef = new EasyCodef();
//        codef.setClientInfoForDemo(EasyCodefClientInfo.DEMO_CLIENT_ID, EasyCodefClientInfo.DEMO_CLIENT_SECRET);
//        codef.setPublicKey(EasyCodefClientInfo.PUBLIC_KEY);
//    }
//
//    @Override
//    public String requestProductMedicalHistory(HashMap<String, Object> data) {
//        return requestProduct(MEDICAL_HISTORY, data);
//    }
//
//    @Override
//    public String requestProductTreatmentInformation(HashMap<String, Object> data) {
//        return requestProduct(TREATMENT_INFORMATION, data);
//    }
//
//    @Override
//    public String requestHealthCheckupResult(HashMap<String, Object> data) {
//        return requestProduct(HEALTH_CHECKUP_RESULT, data);
//    }
//
//    private String requestProduct(String url, HashMap<String, Object> data) {
//        String result = "";
//
//        try {
//            result = codef.requestProduct(url, EasyCodefServiceType.DEMO, data);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }
//
//    @Override
//    public String requestCertificationMedicalHistory(HashMap<String, Object> parameterMap) {
//        return requestCertification(MEDICAL_HISTORY, parameterMap);
//    }
//
//    @Override
//    public String requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap) {
//        return requestCertification(TREATMENT_INFORMATION, parameterMap);
//    }
//
//    @Override
//    public String requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap) {
//        return requestCertification(HEALTH_CHECKUP_RESULT, parameterMap);
//    }
//
//    private String requestCertification(String url, HashMap<String, Object> data) {
//        String result = "";
//        try {
//            result = codef.requestCertification(url, EasyCodefServiceType.DEMO, data);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }
//}