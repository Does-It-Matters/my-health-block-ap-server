package com.example.myhealthblock.question.domain.dto;

import com.example.myhealthblock.question.adapter.out.persistence.question.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionEntityDTO {
    QuestionEntity entity;
}
