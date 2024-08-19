package com.example.myhealthblock.question.adapter.in.web.response;

import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseQuestion {
    private QuestionDTO question;
}