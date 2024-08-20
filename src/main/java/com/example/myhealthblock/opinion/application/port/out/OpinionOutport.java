package com.example.myhealthblock.opinion.application.port.out;

import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutportRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutportDTO;

public interface OpinionOutport {
    OpinionOutportDTO create (OpinionEnrollOutportRequest dto);
    OpinionOutportDTO[] getOpinionsByUserId(int userId);
    OpinionOutportDTO[] getOpinionsByQuestionId(int questionId);
    boolean delete(int id);
}
