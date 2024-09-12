package com.example.myhealthblock.opinion.adapter.out.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "opinions")
public class OpinionDocument {

    @Id
    private String id; // MongoDB uses String as the default ID type
    private int userId;
    private int questionId;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;

    public OpinionDocument() {}

    public OpinionDocument(int userId, int questionId, String content) {
        this.userId = userId;
        this.questionId = questionId;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }
}