//package com.example.myhealthblock.api.healthdata.dto.request;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.HashMap;
//
//@AllArgsConstructor
//@Getter
//@Setter
//public class MedicalHistorySecondRequestDTO {
//    private String organization;
//    private String loginType;
//    private String identity;
//    private String userName;
//    private String loginTypeLevel;
//    private String phoneNo;
//    private String telecom;
//    private String timeOut;
//    private String drugImageYN;
//    private String medicationDirectionYN;
//
//    private String simpleAuth;
//    private boolean is2Way;
//    private int jobIndex;
//    private int threadIndex;
//    private String jti;
//    private Long twoWayTimestamp;
//
//    public HashMap<String, Object> getHashMap() {
//        HashMap<String, Object> parameterMap = new HashMap<String, Object>();
//
//        parameterMap.put("organization", "0002");
//        parameterMap.put("loginType", "5");
//        parameterMap.put("identity", identity);
//        parameterMap.put("userName", userName);
//        parameterMap.put("loginTypeLevel", "1");
//        parameterMap.put("phoneNo", phoneNo);
//        parameterMap.put("telecom", telecom);
//        parameterMap.put("timeOut", "270");
//        parameterMap.put("drugImageYN", "1");
//        parameterMap.put("medicationDirectionYN", "1");
//
//        parameterMap.put("simpleAuth", "1");
//        parameterMap.put("is2Way", true);
//
//        HashMap<String, Object> twoWayInfo = new HashMap<String, Object>();
//        twoWayInfo.put("jobIndex", jobIndex);
//        twoWayInfo.put("threadIndex", threadIndex);
//        twoWayInfo.put("jti", jti);
//        twoWayInfo.put("twoWayTimestamp", twoWayTimestamp);
//        parameterMap.put("twoWayInfo", twoWayInfo);
//
//        return parameterMap;
//    }
//}
