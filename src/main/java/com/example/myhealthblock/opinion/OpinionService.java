package com.example.myhealthblock.opinion;

import com.example.myhealthblock.opinion.adapter.in.request.RequestOpinionEnroll;
import com.example.myhealthblock.opinion.dto.OpinionDTO;
import com.example.myhealthblock.question.GetQuestionEntityDTO;
import com.example.myhealthblock.question.dto.QuestionEntityDTO;
import com.example.myhealthblock.user.GetUserEntityDTO;
import com.example.myhealthblock.user.dto.UserEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpinionService {
    private final OpinionOutport outport;
    private final GetQuestionEntityDTO questionInport;
    private final GetUserEntityDTO userInport;

    public OpinionDTO enroll(RequestOpinionEnroll dto) {
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
