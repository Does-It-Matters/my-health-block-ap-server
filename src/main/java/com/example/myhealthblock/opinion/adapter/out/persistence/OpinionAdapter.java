package com.example.myhealthblock.opinion.adapter.out.persistence;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.opinion.application.port.out.OpinionOutport;
import com.example.myhealthblock.opinion.domain.dto.OpinionDTO;
import com.example.myhealthblock.question.adapter.out.persistence.question.QuestionEntity;
import com.example.myhealthblock.user.adapter.out.persistence.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class OpinionAdapter implements OpinionOutport {
    private static final Logger logger = LoggerFactory.getLogger(OpinionAdapter.class);

    private final OpinionRepository opinionRepository;

    @Override
    public OpinionDTO create(QuestionEntity question, UserEntity user, String content) {
        OpinionEntity opinion = new OpinionEntity();
        opinion.setContent(content);
        opinion.setUser(user);
        opinion.setQuestion(question);
        opinionRepository.save(opinion);
        return mapToDTO(opinion);
    }

    @Override
    public OpinionDTO[] getOpinions(UserEntity user) {
        List<OpinionEntity> opinions = opinionRepository.findByUser(user);
        return getOpinionDTOs(opinions);
    }

    @Override
    public OpinionDTO[] getOpinions(QuestionEntity question) {
        List<OpinionEntity> opinions = opinionRepository.findByQuestion(question);
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

    private OpinionDTO[] getOpinionDTOs(List<OpinionEntity> opinions) {
        return opinions.stream()
                .map(this::mapToDTO)
                .toArray(OpinionDTO[]::new);
    }

    private OpinionDTO mapToDTO(OpinionEntity opinion) {
        int id = opinion.getId();
        String userId = opinion.getUser().getUserId();
        String content = opinion.getContent();
        Date createDate = opinion.getCreateDate();
        Date lastModifiedDate = opinion.getLastModifiedDate();

        return new OpinionDTO(id, userId, content, createDate, lastModifiedDate);
    }
}