package com.example.myhealthblock.question.application.port.in;

import com.example.myhealthblock.question.domain.dto.QuestionEntityDTO;

public interface GetQuestionEntityDTO {
    public QuestionEntityDTO getQuestionEntityDTO(int questionId);
}
