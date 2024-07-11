package com.example.myhealthblock.api.healthdata.specific;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApiTests {

    private TestApi testApi;
    private HashMap<String, Object> testData;

    @BeforeEach
    public void setUp() {
        testApi = new TestApi();
        testData = new HashMap<>();
        testData.put("key1", "value1");
        testData.put("key2", "value2");
    }

    @Test
    public void testRequestProductMedicalHistory() {
        // Given: 테스트 준비 단계 - 필요한 데이터 설정 및 객체 초기화 역할 담당

        // When: 테스트 실행 - 실제 테스트 실행 역할 담당
        String result = testApi.requestProductMedicalHistory(testData);

        // Then: 결과 검증 - 예상한 결과와 실제 결과와 비교하는 역할 담당
        assertEquals("1", result);
    }

    @Test
    public void testRequestProductTreatmentInformation() {
        // Given

        // When
        String result = testApi.requestProductTreatmentInformation(testData);

        // Then
        assertEquals("1", result);
    }

    @Test
    public void testRequestHealthCheckupResult() {
        // Given

        // When
        String result = testApi.requestHealthCheckupResult(testData);

        // Then
        assertEquals("1", result);
    }

    @Test
    public void testRequestCertificationMedicalHistory() {
        // Given

        // When
        String result = testApi.requestCertificationMedicalHistory(testData);

        // Then
        assertEquals("1", result);
    }

    @Test
    public void testRequestCertificationTreatmentInformation() {
        // Given

        // When
        String result = testApi.requestCertificationTreatmentInformation(testData);

        // Then
        assertEquals("1", result);
    }

    @Test
    public void testRequestCertificationHealthCheckupResult() {
        // Given

        // When
        String result = testApi.requestCertificationHealthCheckupResult(testData);

        // Then
        assertEquals("1", result);
    }
}
