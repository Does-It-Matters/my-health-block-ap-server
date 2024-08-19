package com.example.myhealthblock.question.adapter.in.web.response;

import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseQuestionList {
    private QuestionTitleDTO[] list;

    public ResponseQuestionList(QuestionTitleDTO[] list) {
        this.list = list;
    }
}
