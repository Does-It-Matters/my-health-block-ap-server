package com.example.myhealthblock.doctor.adapter.out.database.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <b> 역할: 의료진 데이터 객체 클래스 </b>
 * <br>- 의료진 데이터에 대한 POJO
 */
@Getter
@Setter
public class DoctorEntity {

    private Integer id;
    private String userId;
    private String name;
    private String field;
    private String hospital;
    private String introduction;
    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;

    public DoctorEntity(String userId, String name, String field, String hospital, String introduction) {
        this.userId = userId;
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
        LocalDateTime now = LocalDateTime.now();
        this.createDate = now;
        this.lastEditDate = now;
    }
}