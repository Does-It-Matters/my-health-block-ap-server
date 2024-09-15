package com.example.myhealthblock.opinion.adapter.out.mongodb;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutputPortDTO;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
public class OpinionPersistenceAdapter implements OpinionOutputPort {
    private final OpinionRepository opinionRepository;

    @Override
    public OpinionOutputPortDTO create(OpinionEnrollOutputPortRequest dto) {
        OpinionDocument opinion = new OpinionDocument(dto.getUserId(), dto.getQuestionId(), dto.getContent());
        opinionRepository.save(opinion);
        return mapToDTO(opinion);
    }

    @Override
    public OpinionOutputPortDTO[] getOpinionsByUserId(int userId) {
        List<OpinionDocument> opinions = opinionRepository.findByUserId(userId);
        return getOpinionDTOs(opinions);
    }

    @Override
    public OpinionOutputPortDTO[] getOpinionsByQuestionId(int questionId) {
        List<OpinionDocument> opinions = opinionRepository.findByQuestionId(questionId);
        return getOpinionDTOs(opinions);
    }

    @Override
    public boolean delete(int id) {
        try {
            opinionRepository.deleteById(String.valueOf(id));
            return true;
        } catch (Exception e) {
            // Log error here
            return false;
        }
    }

    private OpinionOutputPortDTO[] getOpinionDTOs(List<OpinionDocument> opinions) {
        return opinions.stream()
                .map(this::mapToDTO)
                .toArray(OpinionOutputPortDTO[]::new);
    }

    private OpinionOutputPortDTO mapToDTO(OpinionDocument opinion) {
        int id = Integer.parseInt(opinion.getId());
        int userId = opinion.getUserId();
        String content = opinion.getContent();
        LocalDateTime createDate = opinion.getCreateDate();
        LocalDateTime lastModifiedDate = opinion.getLastModifiedDate();

        return new OpinionOutputPortDTO(id, userId, content, createDate, lastModifiedDate);
    }
}