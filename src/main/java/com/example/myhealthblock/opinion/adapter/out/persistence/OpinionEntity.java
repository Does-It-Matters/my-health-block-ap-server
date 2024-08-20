package com.example.myhealthblock.opinion.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Entity(name = "opinion")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OpinionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private int questionId;

    private String content;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
}
