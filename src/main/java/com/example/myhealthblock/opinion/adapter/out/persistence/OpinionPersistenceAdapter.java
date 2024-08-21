//package com.example.myhealthblock.opinion.adapter.out.persistence;
//
//import com.example.myhealthblock.aop.LogExecutionTime;
//import com.example.myhealthblock.aop.LogTarget;
//import com.example.myhealthblock.opinion.application.port.out.OpinionOutport;
//import com.example.myhealthblock.opinion.application.port.out.dto.OpinionEnrollOutportRequest;
//import com.example.myhealthblock.opinion.application.port.out.dto.OpinionOutportDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Date;
//import java.util.List;
//
//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
//@RequiredArgsConstructor
//@Service
//public class OpinionPersistenceAdapter implements OpinionOutport {
//    private static final Logger logger = LoggerFactory.getLogger(OpinionPersistenceAdapter.class);
//
//    private final OpinionRepository opinionRepository;
//
//    @Override
//    public OpinionOutportDTO create(OpinionEnrollOutportRequest dto) {
//        OpinionEntity opinion = new OpinionEntity();
//        opinion.setContent(dto.getContent());
//        opinion.setUserId(dto.getUserId());
//        opinion.setQuestionId(dto.getQuestionId());
//        opinionRepository.save(opinion);
//        return mapToDTO(opinion);
//    }
//
//    @Override
//    public OpinionOutportDTO[] getOpinionsByUserId(int userId) {
//        List<OpinionEntity> opinions = opinionRepository.findByUserId(userId);
//        return getOpinionDTOs(opinions);
//    }
//
//    @Override
//    public OpinionOutportDTO[] getOpinionsByQuestionId(int questionId) {
//        List<OpinionEntity> opinions = opinionRepository.findByQuestionId(questionId);
//        return getOpinionDTOs(opinions);
//    }
//
//    @Transactional
//    @Override
//    public boolean delete(int id) {
//        try {
//            OpinionEntity opinion = opinionRepository.findById(id).orElse(null);
//            if (opinion == null) {
//                logger.warn("Opinion with id {} not found.", id);
//                return false;
//            }
//            opinionRepository.delete(opinion);
//            return true;
//        } catch (Exception e) {
//            logger.error("Error deleting opinion with id {}: {}", id, e.getMessage());
//            return false;
//        }
//    }
//
//    private OpinionOutportDTO[] getOpinionDTOs(List<OpinionEntity> opinions) {
//        return opinions.stream()
//                .map(this::mapToDTO)
//                .toArray(OpinionOutportDTO[]::new);
//    }
//
//    private OpinionOutportDTO mapToDTO(OpinionEntity opinion) {
//        int id = opinion.getId();
//        int userId = opinion.getUserId();
//        String content = opinion.getContent();
//        Date createDate = opinion.getCreateDate();
//        Date lastModifiedDate = opinion.getLastModifiedDate();
//
//        return new OpinionOutportDTO(id, userId, content, createDate, lastModifiedDate);
//    }
//}