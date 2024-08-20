package com.example.myhealthblock.opinion.application.port.in;

import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInportRequest;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInportDTO;

public interface OpinionInport {
    OpinionInportDTO enroll(OpinionEnrollInportRequest dto);
    OpinionInportDTO[] getOpinionsByUserId(int userId);
    OpinionInportDTO[] getOpinionsByQuestionId(int questionId);
    String delete(Integer opinionId);
}
