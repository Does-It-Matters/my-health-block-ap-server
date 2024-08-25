package com.example.myhealthblock.question.application.port.out;

import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;

public interface QuestionOutputPort {
    boolean create(QuestionEnrollOutputPortRequest dto);
    QuestionDTO getQuestion(int id);
    boolean delete(int id);
    QuestionTitleDTO[] getQuestions(int userId);
    QuestionTitleDTO[] getQuestions(Category category);
    QuestionTitleDTO[] getQuestions();
    boolean update(Integer questionId, String title, String symptom, String content);
}
