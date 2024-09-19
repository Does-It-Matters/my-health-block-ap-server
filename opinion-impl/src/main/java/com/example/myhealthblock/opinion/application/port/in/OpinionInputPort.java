package com.example.myhealthblock.opinion.application.port.in;

import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInputPortRequest;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInputPortDTO;

public interface OpinionInputPort {
    OpinionInputPortDTO enroll(OpinionEnrollInputPortRequest dto);
    OpinionInputPortDTO[] getOpinionsByUserId(int userId);
    OpinionInputPortDTO[] getOpinionsByQuestionId(int questionId);
    String delete(Integer opinionId);
}
