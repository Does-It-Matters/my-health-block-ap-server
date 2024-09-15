package com.example.myhealthblock.opinion.adapter.out.database.jpa;

import com.example.myhealthblock.opinion.application.port.out.OpinionOutputPort;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutputPortRequest;
import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutputPortDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
public class OpinionPersistenceAdapter implements OpinionOutputPort {
    private static final Logger logger = LoggerFactory.getLogger(OpinionPersistenceAdapter.class);

    private final OpinionRepository opinionRepository;

    @Override
    public OpinionOutputPortDTO create(OpinionEnrollOutputPortRequest dto) {
        OpinionEntity opinion = new OpinionEntity();
        opinion.setContent(dto.getContent());
        opinion.setUserId(dto.getUserId());
        opinion.setQuestionId(dto.getQuestionId());
        opinionRepository.save(opinion);
        return mapToDTO(opinion);
    }

    @Override
    public OpinionOutputPortDTO[] getOpinionsByUserId(int userId) {
        List<OpinionEntity> opinions = opinionRepository.findByUserId(userId);
        return getOpinionDTOs(opinions);
    }

    @Override
    public OpinionOutputPortDTO[] getOpinionsByQuestionId(int questionId) {
        List<OpinionEntity> opinions = opinionRepository.findByQuestionId(questionId);
        return getOpinionDTOs(opinions);
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        try {
            OpinionEntity opinion = opinionRepository.findById(id).orElse(null);
            if (opinion == null) {
                logger.warn("Opinion with id {} not found.", id);
                return false;
            }
            opinionRepository.delete(opinion);
            return true;
        } catch (Exception e) {
            logger.error("Error deleting opinion with id {}: {}", id, e.getMessage());
            return false;
        }
    }

    private OpinionOutputPortDTO[] getOpinionDTOs(List<OpinionEntity> opinions) {
        return opinions.stream()
                .map(this::mapToDTO)
                .toArray(OpinionOutputPortDTO[]::new);
    }

    private OpinionOutputPortDTO mapToDTO(OpinionEntity opinion) {
        int id = opinion.getId();
        int userId = opinion.getUserId();
        String content = opinion.getContent();
        LocalDateTime createDate = opinion.getCreateDate();
        LocalDateTime lastModifiedDate = opinion.getLastModifiedDate();

        return new OpinionOutputPortDTO(id, userId, content, createDate, lastModifiedDate);
    }
}