package com.example.myhealthblock.question.adapter.out.database.mongodb.question;

import com.example.myhealthblock.question.common.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "questions")
public class QuestionDocument {

    @Id
    private String id;
    private Integer userId;
    private String title;
    private Category category;
    private String symptom;
    private String content;
    private LocalDateTime createDate;
    private List<String> bodyPartIds; // Store BodyPartMapping IDs
}