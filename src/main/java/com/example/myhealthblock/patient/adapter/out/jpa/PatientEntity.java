package com.example.myhealthblock.patient.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Patient")
@EntityListeners(AuditingEntityListener.class)
public class PatientEntity {
    public PatientEntity(String userId){
        this();
        this.userId = userId;
    }

    public PatientEntity() {
        this.createDate = LocalDateTime.now();
        this.lastEditDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userId;

    @Column
    private String urgentData;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastEditDate;
}