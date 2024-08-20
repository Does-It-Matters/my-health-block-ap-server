package com.example.myhealthblock.opinion.application.port.in;

import com.example.myhealthblock.opinion.adapter.in.web.request.OpinionEnrollRequest;
import com.example.myhealthblock.opinion.domain.dto.OpinionDTO;

public interface OpinionInport {
    OpinionDTO enroll(OpinionEnrollRequest dto);
    OpinionDTO[] getOpinions(String userId);
    OpinionDTO[] getOpinions(Integer questionId);
    String delete(Integer opinionId);
}
