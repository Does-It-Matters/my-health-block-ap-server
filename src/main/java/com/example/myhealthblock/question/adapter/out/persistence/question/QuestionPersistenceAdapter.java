//package com.example.myhealthblock.question.adapter.out.persistence.question;
//
//import com.example.myhealthblock.aop.LogExecutionTime;
//import com.example.myhealthblock.aop.LogTarget;
//import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutportRequest;
//import com.example.myhealthblock.question.common.Category;
//import com.example.myhealthblock.question.application.port.out.QuestionOutport;
//import com.example.myhealthblock.question.adapter.out.persistence.bodypart.BodyMappingRepository;
//import com.example.myhealthblock.question.adapter.out.persistence.bodypart.BodyPartMappingEntity;
//import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
//import com.example.myhealthblock.question.domain.dto.QuestionDTO;
//import com.example.myhealthblock.question.adapter.out.persistence.personaldata.PersonalDataEntity;
//import com.example.myhealthblock.question.adapter.out.persistence.personaldata.PersonalDataRepository;
//
//import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
//@RequiredArgsConstructor
//@Service
//public class QuestionPersistenceAdapter implements QuestionOutport {
//    private final QuestionRepository questionRepository;
//    private final PersonalDataRepository personalDataRepository;
//    private final BodyMappingRepository bodyMappingRepository;
//
//    @Override
//    public boolean create(QuestionEnrollOutportRequest dto) {
//        QuestionEntity question = new QuestionEntity(dto.getUserId(), dto.getTitle(), dto.getCategory(), dto.getSymptom(), dto.getContent());
//        questionRepository.save(question);
//
//        insertBodyParts(question, dto.getBodyParts());
//        insertPersonalData(question, dto.getPersonalData());
//
//        return true;
//    }
//
//    private void insertBodyParts(QuestionEntity question, List<BodyPart> bodyParts) {
//        if (bodyParts == null) {
//            return;
//        }
//        for (BodyPart bodyPart : bodyParts) {
//            bodyMappingRepository.save(new BodyPartMappingEntity(question, bodyPart));
//        }
//    }
//
//    private void insertPersonalData(QuestionEntity question, PersonalDataDTO personalData) {
//        if (personalData != null) {
//            personalDataRepository.save(getPersonalDataEntity(question, personalData));
//        }
//    }
//
//    private PersonalDataEntity getPersonalDataEntity(QuestionEntity question, PersonalDataDTO personalData) {
//        PersonalDataEntity personalDataEntity = new PersonalDataEntity();
//        personalDataEntity.setQuestion(question);
//        personalDataEntity.setAge(personalData.getAge());
//        personalDataEntity.setGender(personalData.getGender());
//        personalDataEntity.setDisease(personalData.getDisease());
//        personalDataEntity.setMedication(personalData.getMedication());
//
//        return personalDataEntity;
//    }
//
//    @Override
//    public QuestionDTO getQuestion(int id) {
//        QuestionEntity questionEntity = getQuestionEntity(id);
//        if (questionEntity == null) {
//            return null;
//        }
//
//        return getQuestionDTO(questionEntity);
//    }
//
//    @Override
//    public QuestionTitleDTO[] getQuestions(int userId) {
//        return getQuestionTitleDTOs(this.questionRepository.findAllByUserId(userId));
//    }
//
//    @Override
//    public QuestionTitleDTO[] getQuestions(Category category) {
//        return getQuestionTitleDTOs(this.questionRepository.findAllByCategory(category));
//    }
//
//    @Override
//    public QuestionTitleDTO[] getQuestions() {
//        return getQuestionTitleDTOs(this.questionRepository.findAll());
//    }
//
//    @Override
//    public boolean update(Integer questionId, String title, String symptom, String content) {
//        QuestionEntity question = getQuestionEntity(questionId);
//        question.setTitle(title);
//        question.setSymptom(symptom);
//        question.setContent(content);
//        questionRepository.save(question);
//
//        return true;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        QuestionEntity questionEntity = getQuestionEntity(id);
//        PersonalDataEntity personalData = personalDataRepository.findByQuestion(questionEntity);
//
//        if (personalData != null) {
//            personalDataRepository.delete(personalData);
//        }
//
//        if (questionEntity == null) {
//            return false;
//        }
//
//        deleteQuestion(questionEntity);
//        return true;
//    }
//
//
//    private QuestionEntity getQuestionEntity(int id) {
//        return this.questionRepository.findById(id).orElse(null);
//    }
//
//    private QuestionTitleDTO[] getQuestionTitleDTOs(List<QuestionEntity> questionEntities) {
//        return questionEntities.stream()
//                .map(this::getQuestionTitleDTO)
//                .toArray(QuestionTitleDTO[]::new);
//    }
//
//    private QuestionDTO getQuestionDTO(QuestionEntity questionEntity) {
//        PersonalDataDTO personalData = getPersonalDataDTO(personalDataRepository.findByQuestion(questionEntity));
//        List<BodyPart> bodyParts = getBodyParts(questionEntity);
//
//        return new QuestionDTO(
//                questionEntity.getId(),
//                questionEntity.getUserId(),
//                questionEntity.getTitle(),
//                questionEntity.getCategory(),
//                questionEntity.getSymptom(),
//                questionEntity.getContent(),
//                bodyParts,
//                personalData
//        );
//    }
//
//    private QuestionTitleDTO getQuestionTitleDTO(QuestionEntity questionEntity) {
//        return new QuestionTitleDTO(questionEntity.getId(), questionEntity.getTitle());
//    }
//
//    private PersonalDataDTO getPersonalDataDTO(PersonalDataEntity personalDataEntity) {
//        if (personalDataEntity == null) {
//            return null;
//        }
//
//        PersonalDataDTO personalData = new PersonalDataDTO();
//
//        personalData.setAge(personalDataEntity.getAge());
//        personalData.setGender(personalDataEntity.getGender());
//        personalData.setDisease(personalDataEntity.getDisease());
//        personalData.setMedication(personalDataEntity.getMedication());
//
//        return personalData;
//    }
//
//    private List<BodyPart> getBodyParts(QuestionEntity questionEntity) {
//        return this.bodyMappingRepository.findByQuestion(questionEntity)
//                .stream()
//                .map(BodyPartMappingEntity::getBodyPart)
//                .collect(Collectors.toList());
//    }
//
//    private void deleteQuestion(QuestionEntity questionEntity) {
//        this.questionRepository.delete(questionEntity);
//    }
//}