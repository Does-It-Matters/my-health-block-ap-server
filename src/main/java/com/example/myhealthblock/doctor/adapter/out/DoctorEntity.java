package com.example.myhealthblock.doctor.adapter.out;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Doctor")
@NoArgsConstructor
public class DoctorEntity {

    public DoctorEntity(String uid, String name, String field, String hospital, String introduction) {
        this.userId = uid;
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
        createDate = LocalDateTime.now();
        lastEditDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    String userId;

    @Column(length = 200)
    String name;

    @Column(length = 200)
    String field;

    @Column(length = 200)
    String hospital;

    @Column(length = 200)
    String introduction;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime lastEditDate;
}
