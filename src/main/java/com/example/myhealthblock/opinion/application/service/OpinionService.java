package com.example.myhealthblock.opinion.application.service;

import com.example.myhealthblock.opinion.adapter.in.web.request.OpinionEnrollRequest;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutport;
import com.example.myhealthblock.opinion.domain.dto.OpinionDTO;
import com.example.myhealthblock.question.application.port.in.GetQuestionEntityDTO;
import com.example.myhealthblock.question.domain.dto.QuestionEntityDTO;
import com.example.myhealthblock.user.application.port.in.GetUserEntityDTO;
import com.example.myhealthblock.user.domain.dto.UserEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpinionService {
    private final OpinionOutport outport;
    private final GetQuestionEntityDTO questionInport;
    private final GetUserEntityDTO userInport;

    public OpinionDTO enroll(OpinionEnrollRequest dto) {
        QuestionEntityDTO questionDto = questionInport.getQuestionEntityDTO(dto.getQuestionId());
        UserEntityDTO userDto = userInport.getUserEntityDTO(dto.getUserId());

        return outport.create(questionDto.getEntity(), userDto.getEntity(), dto.getContent());
    }

    public OpinionDTO[] getOpinions(String userId) {
        UserEntityDTO userDto = userInport.getUserEntityDTO(userId);
        return outport.getOpinions(userDto.getEntity());
    }

    public OpinionDTO[] getOpinions(Integer questionId) {
        QuestionEntityDTO questionDto = questionInport.getQuestionEntityDTO(questionId);
        return outport.getOpinions(questionDto.getEntity());
    }

    public String delete(Integer opinionId) {
        boolean result = outport.delete(opinionId);
        return result ? "success" : "fail";
    }
}
