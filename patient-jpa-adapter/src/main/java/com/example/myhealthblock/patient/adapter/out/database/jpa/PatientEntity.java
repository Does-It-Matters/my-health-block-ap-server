package com.example.myhealthblock.patient.adapter.out.database.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * <b> 역할: 환자 엔티티 클래스 </b>
 * <p>
 * - 데이터베이스의 'patient' 테이블과 매핑 <br>
 * - JPA와 Hibernate를 통해 데이터베이스와 상호작용 <br>
 * </p>
 */
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
