package com.example.myhealthblock.doctor.adapter.out.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "doctors")
public class DoctorDocument {

    @Id
    private String id;
    private String userId;
    private String name;
    private String field;
    private String hospital;
    private String introduction;
    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;

    public DoctorDocument() {}

    public DoctorDocument(String userId, String name, String field, String hospital, String introduction) {
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