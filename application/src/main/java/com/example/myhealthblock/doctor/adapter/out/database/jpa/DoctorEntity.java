package com.example.myhealthblock.doctor.adapter.out.database.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * <b> 역할: 의료진 엔티티 클래스 </b>
 * <br>- 의료진 엔티티
 */
@Getter
@Setter
@Entity(name = "Doctor")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class DoctorEntity {

    public DoctorEntity(String uid, String name, String field, String hospital, String introduction) {
        this.userId = uid;
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
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

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastEditDate;
}
