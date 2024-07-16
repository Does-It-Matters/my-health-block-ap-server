//package com.example.myhealthblock.api.healthdata.dto.response;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class TreatmentInfoResponseDTO<T> {
////    private ResultDTO resultDTO;
//
//    @JsonProperty("data")
//    private T data;
//
////    @JsonProperty("contractAddress")
////    private String contractAddress;
//    @Override
//    public String toString() {
////        String dtoAsString = "resultDTO= {" + resultDTO +"}, data = {"+ data +"}";
//        System.out.println("Class Name: " + data.getClass().getName());
//        ArrayList arr = (ArrayList)data;
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.println("arr : "  + i + "," + arr.get(i));
//            System.out.println("arr : "  + i + "," + arr.get(i).getClass().getName());
//        }
//        System.out.println("Data: ");
//        System.out.println("Data: " + data.toString());
//        System.out.println("Data: " + arr.size());
//        System.out.println("Data: ");
//        return "data.toString()";
//    }
//}
