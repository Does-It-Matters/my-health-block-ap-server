package com.example.myhealthblock.question.application.service;

import com.example.myhealthblock.question.application.port.in.QuestionInport;
import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInportRequest;
import com.example.myhealthblock.question.application.port.out.QuestionOutputPort;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutportRequest;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import com.example.myhealthblock.question.domain.mapper.QuestionMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService implements QuestionInport {
    private final QuestionOutputPort outputPort;
    private final QuestionMapper mapper = QuestionMapper.INSTANCE;

    @Override
    public String enroll(QuestionEnrollInportRequest dto) {
        QuestionEnrollOutportRequest request = mapper.INSTANCE.inportRequestToOutportRequest(dto);
        boolean result = outputPort.create(request);

        return result ? "success" : "fail";
    }

    @Override
    public QuestionDTO getQuestion(Integer questionId) {
        return outputPort.getQuestion(questionId);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(int userId) {
        return outputPort.getQuestions(userId);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(Category category) {
        return outputPort.getQuestions(category);
    }

    @Override
    public QuestionTitleDTO[] getQuestions() {
        return outputPort.getQuestions();
    }

    @Override
    public String update(Integer questionId, String title, String symptom, String content) {
        boolean result = outputPort.update(questionId, title, symptom, content);
        return result ? "success" : "fail";
    }

    @Override
    public String delete(Integer questionId) {
        boolean result = outputPort.delete(questionId);
        return result ? "success" : "fail";
    }
}
