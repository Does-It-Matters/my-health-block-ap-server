package com.example.myhealthblock.opinion.application.port.out;

import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutputPortDTO;

public interface OpinionOutputPort {
    OpinionOutputPortDTO create (OpinionEnrollOutputPortRequest dto);
    OpinionOutputPortDTO[] getOpinionsByUserId(int userId);
    OpinionOutputPortDTO[] getOpinionsByQuestionId(int questionId);
    boolean delete(int id);
}
