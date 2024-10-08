package com.example.myhealthblock.question.adapter.out.database.mybatis.question;

import com.example.myhealthblock.question.adapter.out.database.mybatis.bodypart.BodyPartMappingMapper;
import com.example.myhealthblock.question.adapter.out.database.mybatis.personaldata.PersonalDataEntity;
import com.example.myhealthblock.question.adapter.out.database.mybatis.personaldata.PersonalDataMapper;
import com.example.myhealthblock.question.application.port.out.QuestionOutputPort;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import com.example.myhealthblock.question.common.BodyPart;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import com.example.myhealthblock.question.adapter.out.database.mybatis.bodypart.BodyPartMappingEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Component
public class QuestionPersistenceAdapter implements QuestionOutputPort {
    private final QuestionMapper questionMapper;
    private final PersonalDataMapper personalDataMapper;
    private final BodyPartMappingMapper bodyPartMappingMapper;

    @Override
    public boolean create(QuestionEnrollOutputPortRequest dto) {
        QuestionEntity question = saveQuestion(dto);
        insertBodyParts(question.getId(), dto.getBodyParts());
        insertPersonalData(question.getId(), dto.getPersonalData());
        return true;
    }

    private QuestionEntity saveQuestion(QuestionEnrollOutputPortRequest dto) {
        QuestionEntity question = new QuestionEntity();
        question.setUserId(dto.getUserId());
        question.setTitle(dto.getTitle());
        question.setCategory(dto.getCategory());
        question.setSymptom(dto.getSymptom());
        question.setContent(dto.getContent());
        question.setCreateDate(LocalDateTime.now());
        questionMapper.insertQuestion(question);
        return question;
    }

    private void insertBodyParts(Integer questionId, List<BodyPart> bodyParts) {
        if (bodyParts != null) {
            for (BodyPart bodyPart : bodyParts) {
                bodyPartMappingMapper.insertBodyPartMapping(new BodyPartMappingEntity(questionId, bodyPart));
            }
        }
    }

    private void insertPersonalData(Integer questionId, PersonalDataDTO personal) {
        if (personal != null) {
            personalDataMapper.insertPersonalData(new PersonalDataEntity(questionId, personal.getAge(), personal.getGender(), personal.getDisease(), personal.getMedication()));
        }
    }

    @Override
    public QuestionDTO getQuestion(int id) {
        QuestionEntity questionEntity = questionMapper.findById(id);
        if (questionEntity == null) {
            return null;
        }

        return getQuestionDTO(questionEntity);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(int userId) {
        List<QuestionEntity> questionEntities = questionMapper.findAllByUserId(userId);
        return getQuestionTitleDTOs(questionEntities);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(Category category) {
        List<QuestionEntity> questionEntities = questionMapper.findAllByCategory(category);
        return getQuestionTitleDTOs(questionEntities);
    }

    @Override
    public QuestionTitleDTO[] getQuestions() {
        List<QuestionEntity> questionEntities = questionMapper.findAll();
        return getQuestionTitleDTOs(questionEntities);
    }

    @Override
    public boolean update(Integer questionId, String title, String symptom, String content) {
        QuestionEntity question = questionMapper.findById(questionId);
        if (question == null) {
            return false;
        }

        question.setTitle(title);
        question.setSymptom(symptom);
        question.setContent(content);
        questionMapper.updateQuestion(question);
        return true;
    }

    @Override
    public boolean delete(int id) {
        QuestionEntity questionEntity = questionMapper.findById(id);
        if (questionEntity == null) {
            return false;
        }

        PersonalDataEntity personalData = personalDataMapper.findByQuestionId(questionEntity.getId());
        if (personalData != null) {
            personalDataMapper.deletePersonalData(personalData.getId());
        }

        bodyPartMappingMapper.deleteByQuestionId(questionEntity.getId());
        questionMapper.deleteQuestion(questionEntity.getId());
        return true;
    }

    private QuestionTitleDTO[] getQuestionTitleDTOs(List<QuestionEntity> questionEntities) {
        return questionEntities.stream()
                .map(q -> new QuestionTitleDTO(getStringQuestionId(q.getId()), q.getTitle()))
                .toArray(QuestionTitleDTO[]::new);
    }

    private QuestionDTO getQuestionDTO(QuestionEntity q) {
        PersonalDataEntity personal = personalDataMapper.findByQuestionId(q.getId());
        List<BodyPart> bodyParts = bodyPartMappingMapper.findByQuestionId(q.getId()).stream()
                .map(BodyPartMappingEntity::getBodyPart)
                .collect(Collectors.toList());

        return new QuestionDTO(getStringQuestionId(q.getId()), q.getUserId(), q.getTitle(), q.getCategory(), q.getSymptom(), q.getContent(), bodyParts,
                new PersonalDataDTO(personal.getAge(), personal.getGender(), personal.getDisease(), personal.getMedication()));
    }

    private String getStringQuestionId(int questionId) {
        return String.valueOf(questionId);
    }
}