package com.example.myhealthblock.api.healthdata.specific;

import java.util.HashMap;

public class TestApi implements Api{
    @Override
    public String requestProductMedicalHistory(HashMap<String, Object> data) {
        return "1";
    }

    @Override
    public String requestProductTreatmentInformation(HashMap<String, Object> data) {
        return "1";
    }

    @Override
    public String requestHealthCheckupResult(HashMap<String, Object> data) {
        return "1";
    }

    @Override
    public String requestCertificationMedicalHistory(HashMap<String, Object> parameterMap) {
        return "1";
    }

    @Override
    public String requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap) {
        return "1";
    }

    @Override
    public String requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap) {
        return "1";
    }
}
