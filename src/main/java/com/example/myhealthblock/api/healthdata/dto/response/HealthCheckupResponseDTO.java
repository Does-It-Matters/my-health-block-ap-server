//package com.example.myhealthblock.api.healthdata.dto.response;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.apache.commons.codec.digest.DigestUtils;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class HealthCheckupResponseDTO<T> {
//    @JsonProperty("result")
//    private ResultDTO resultDTO;
//    @JsonProperty("data")
//    private T data;
//
//    @Override
//    public String toString() {
//        String dtoAsString =
//                "resultDTO= {" + resultDTO +
//                "}, data= {" + data +
//                '}';
//
//        return DigestUtils.sha256Hex(dtoAsString);
//    }
//}
