package com.example.myhealthblock.question.application.service;

import com.example.myhealthblock.question.application.port.in.QuestionInport;
import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInportRequest;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutportRequest;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.application.port.out.QuestionOutport;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import com.example.myhealthblock.question.domain.mapper.QuestionMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService implements QuestionInport {
    private final QuestionOutport outport;
    private final QuestionMapper mapper = QuestionMapper.INSTANCE;

    @Override
    public String enroll(QuestionEnrollInportRequest dto) {
        QuestionEnrollOutportRequest request = mapper.INSTANCE.inportRequestToOutportRequest(dto);
        boolean result = outport.create(request);

        return result ? "success" : "fail";
    }

    @Override
    public QuestionDTO getQuestion(Integer questionId) {
        return outport.getQuestion(questionId);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(int userId) {
        return outport.getQuestions(userId);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(Category category) {
        return outport.getQuestions(category);
    }

    @Override
    public QuestionTitleDTO[] getQuestions() {
        return outport.getQuestions();
    }

    @Override
    public String update(Integer questionId, String title, String symptom, String content) {
        boolean result = outport.update(questionId, title, symptom, content);
        return result ? "success" : "fail";
    }

    @Override
    public String delete(Integer questionId) {
        boolean result = outport.delete(questionId);
        return result ? "success" : "fail";
    }
}
