package com.example.myhealthblock.opinion.application.service;

import com.example.myhealthblock.doctor.domain.mapper.DoctorMapper;
import com.example.myhealthblock.opinion.application.port.in.OpinionInport;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInportRequest;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutport;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInportDTO;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutportRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutportDTO;
import com.example.myhealthblock.opinion.domain.mapper.OpinionMapper;
import com.example.myhealthblock.question.application.port.in.GetQuestionEntityDTO;
import com.example.myhealthblock.user.application.port.in.GetUserEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpinionService implements OpinionInport {
    private final OpinionOutport outport;
    private final GetQuestionEntityDTO questionInport;
    private final GetUserEntityDTO userInport;
    private final OpinionMapper mapper = OpinionMapper.INSTANCE;

    @Override
    public OpinionInportDTO enroll(OpinionEnrollInportRequest dto) {
        OpinionEnrollOutportRequest request = OpinionMapper.INSTANCE.opinionEnrollOutportRequestToOpinionEnrollOutportResponse(dto);
        OpinionOutportDTO response = outport.create(request);
        return mapper.INSTANCE.opinionEnrollOutportResponseToOpinionEnrollInportResponse(response);
    }

    @Override
    public OpinionInportDTO[] getOpinionsByUserId(int userId) {
        OpinionOutportDTO[] outportDTOs = outport.getOpinionsByUserId(userId);
        return mapper.INSTANCE.opinionOutportArrayToInportArray(outportDTOs);
    }

    @Override
    public OpinionInportDTO[] getOpinionsByQuestionId(int questionId) {
        OpinionOutportDTO[] outportDTOs = outport.getOpinionsByQuestionId(questionId);
        return mapper.INSTANCE.opinionOutportArrayToInportArray(outportDTOs);
    }

    @Override
    public String delete(Integer opinionId) {
        boolean result = outport.delete(opinionId);
        return result ? "success" : "fail";
    }
}
