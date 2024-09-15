package com.example.myhealthblock.opinion.adapter.out.database.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OpinionEntity {

    private Integer id;
    private int userId;
    private int questionId;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;

    public OpinionEntity() {}

    public OpinionEntity(int userId, int questionId, String content) {
        this.userId = userId;
        this.questionId = questionId;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }
}