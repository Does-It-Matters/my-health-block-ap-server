package com.example.myhealthblock.question.adapter.in.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestQuestionUpdate {
    private Integer questionId;
    private String title;
    private String symptom;
    private String content;
}
