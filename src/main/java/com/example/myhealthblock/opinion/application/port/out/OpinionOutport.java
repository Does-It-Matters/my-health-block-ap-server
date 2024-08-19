package com.example.myhealthblock.opinion.application.port.out;

import com.example.myhealthblock.opinion.domain.dto.OpinionDTO;
import com.example.myhealthblock.question.adapter.out.persistence.question.QuestionEntity;
import com.example.myhealthblock.user.adapter.out.persistence.UserEntity;

public interface OpinionOutport {
    public OpinionDTO create (QuestionEntity question, UserEntity user, String content);
    public OpinionDTO[] getOpinions(UserEntity user);
    public OpinionDTO[] getOpinions(QuestionEntity question);
    public boolean delete(int id);
}
