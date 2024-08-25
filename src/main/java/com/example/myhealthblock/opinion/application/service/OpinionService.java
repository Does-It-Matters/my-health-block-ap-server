package com.example.myhealthblock.opinion.application.service;

import com.example.myhealthblock.opinion.application.port.in.OpinionInputPort;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionEnrollInputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInputPortDTO;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutputPortDTO;
import com.example.myhealthblock.opinion.domain.mapper.OpinionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpinionService implements OpinionInputPort {
    private final OpinionOutputPort outputPort;
    private final OpinionMapper mapper = OpinionMapper.INSTANCE;

    @Override
    public OpinionInputPortDTO enroll(OpinionEnrollInputPortRequest dto) {
        OpinionEnrollOutputPortRequest request = OpinionMapper.INSTANCE.toEnrollOutputPortRequest(dto);
        OpinionOutputPortDTO response = outputPort.create(request);
        return mapper.INSTANCE.toEnrollInput(response);
    }

    @Override
    public OpinionInputPortDTO[] getOpinionsByUserId(int userId) {
        OpinionOutputPortDTO[] outputPortDTOs = outputPort.getOpinionsByUserId(userId);
        return mapper.INSTANCE.toEnrollInputArray(outputPortDTOs);
    }

    @Override
    public OpinionInputPortDTO[] getOpinionsByQuestionId(int questionId) {
        OpinionOutputPortDTO[] outputPortDTOs = outputPort.getOpinionsByQuestionId(questionId);
        return mapper.INSTANCE.toEnrollInputArray(outputPortDTOs);
    }

    @Override
    public String delete(Integer opinionId) {
        boolean result = outputPort.delete(opinionId);
        return result ? "success" : "fail";
    }
}
