package com.example.myhealthblock.patient.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Patient")
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

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime lastEditDate;
}
