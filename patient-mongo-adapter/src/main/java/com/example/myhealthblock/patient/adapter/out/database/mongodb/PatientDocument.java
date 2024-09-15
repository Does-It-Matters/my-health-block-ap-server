package com.example.myhealthblock.patient.adapter.out.database.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "patients")
public class PatientDocument {

    @Id
    private String id; // MongoDB uses String as the default ID type
    private String userId;
    private String urgentData;
    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;

    public PatientDocument() {}

    public PatientDocument(String userId) {
        this.userId = userId;
        this.createDate = LocalDateTime.now();
        this.lastEditDate = LocalDateTime.now();
    }
}