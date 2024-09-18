package com.example.myhealthblock.opinion.adapter.out.database.mybatis;

import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutputPortDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Component
public class OpinionPersistenceAdapter implements OpinionOutputPort {
    private final OpinionMapper opinionMapper;

    @Override
    public OpinionOutputPortDTO create(OpinionEnrollOutputPortRequest dto) {
        OpinionEntity opinion = new OpinionEntity(dto.getUserId(), dto.getQuestionId(), dto.getContent());
        opinionMapper.insertOpinion(opinion);
        return mapToDTO(opinion);
    }

    @Override
    public OpinionOutputPortDTO[] getOpinionsByUserId(int userId) {
        List<OpinionEntity> opinions = opinionMapper.selectOpinionsByUserId(userId);
        return getOpinionDTOs(opinions);
    }

    @Override
    public OpinionOutputPortDTO[] getOpinionsByQuestionId(int questionId) {
        List<OpinionEntity> opinions = opinionMapper.selectOpinionsByQuestionId(questionId);
        return getOpinionDTOs(opinions);
    }

    @Override
    public boolean delete(int id) {
        try {
            opinionMapper.deleteOpinion(id);
            return true;
        } catch (Exception e) {
            // Log error here
            return false;
        }
    }

    private OpinionOutputPortDTO[] getOpinionDTOs(List<OpinionEntity> opinions) {
        return opinions.stream()
                .map(this::mapToDTO)
                .toArray(OpinionOutputPortDTO[]::new);
    }

    private OpinionOutputPortDTO mapToDTO(OpinionEntity opinion) {
        return new OpinionOutputPortDTO(
                opinion.getId(),
                opinion.getUserId(),
                opinion.getContent(),
                opinion.getCreateDate(),
                opinion.getLastModifiedDate()
        );
    }
}