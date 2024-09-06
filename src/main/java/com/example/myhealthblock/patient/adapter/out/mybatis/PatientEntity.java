package com.example.myhealthblock.patient.adapter.out.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <b> 역할: 환자 엔티티 클래스 </b>
 * <p>
 * - 데이터베이스의 'patient' 테이블과 매핑 <br>
 * - MyBatis 매퍼와의 상호작용을 위해 사용됨 <br>
 * </p>
 */
@Getter
@Setter
public class PatientEntity {

    private Integer id;
    private String userId;
    private String urgentData;
    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;

    public PatientEntity() {}

    public PatientEntity(String userId) {
        this.userId = userId;
        this.createDate = LocalDateTime.now();
        this.lastEditDate = LocalDateTime.now();
    }
}