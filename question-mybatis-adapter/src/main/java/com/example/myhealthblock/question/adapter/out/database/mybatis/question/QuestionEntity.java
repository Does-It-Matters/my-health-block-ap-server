package com.example.myhealthblock.question.adapter.out.database.mybatis.question;

import com.example.myhealthblock.question.common.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class QuestionEntity {

    private Integer id;
    private Integer userId;
    private String title;
    private Category category;
    private String symptom;
    private String content;
    private LocalDateTime createDate;
    private List<Integer> bodyPartIds; // List of BodyPartMapping IDs
}