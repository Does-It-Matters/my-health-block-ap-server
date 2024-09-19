package com.example.myhealthblock.question.adapter.out.database.mongodb.question;

import com.example.myhealthblock.question.adapter.out.database.mongodb.bodypart.BodyPartMappingDocument;
import com.example.myhealthblock.question.adapter.out.database.mongodb.bodypart.BodyPartMappingRepository;
import com.example.myhealthblock.question.application.port.out.QuestionOutputPort;
import com.example.myhealthblock.question.application.port.out.dto.QuestionEnrollOutputPortRequest;
import com.example.myhealthblock.question.common.BodyPart;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import com.example.myhealthblock.question.adapter.out.database.mongodb.personaldata.PersonalDataDocument;
import com.example.myhealthblock.question.adapter.out.database.mongodb.personaldata.PersonalDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Component
public class QuestionPersistenceAdapter implements QuestionOutputPort {
    private final QuestionRepository questionRepository;
    private final PersonalDataRepository personalDataRepository;
    private final BodyPartMappingRepository bodyMappingRepository;

    @Override
    public boolean create(QuestionEnrollOutputPortRequest dto) {
        QuestionDocument question = saveQuestion(dto);
        insertBodyParts(question.getId(), dto.getBodyParts());
        insertPersonalData(question.getId(), dto.getPersonalData());
        return true;
    }

    private QuestionDocument saveQuestion(QuestionEnrollOutputPortRequest dto) {
        QuestionDocument question = new QuestionDocument();
        question.setUserId(dto.getUserId());
        question.setTitle(dto.getTitle());
        question.setCategory(dto.getCategory());
        question.setSymptom(dto.getSymptom());
        question.setContent(dto.getContent());
        question.setCreateDate(LocalDateTime.now());
        return questionRepository.save(question);
    }

    private void insertBodyParts(String questionId, List<BodyPart> bodyParts) {
        if (bodyParts != null) {
            for (BodyPart bodyPart : bodyParts) {
                bodyMappingRepository.save(new BodyPartMappingDocument(questionId, bodyPart));
            }
        }
    }

    private void insertPersonalData(String questionId, PersonalDataDTO personal) {
        if (personal != null) {
            personalDataRepository.save(new PersonalDataDocument(questionId, personal.getAge(), personal.getGender(), personal.getDisease(), personal.getMedication()));
        }
    }

    @Override
    public QuestionDTO getQuestion(int id) {
        QuestionDocument questionDocument = questionRepository.findById(String.valueOf(id)).orElse(null);
        if (questionDocument == null) {
            return null;
        }

        return getQuestionDTO(questionDocument);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(int userId) {
        List<QuestionDocument> questionDocuments = questionRepository.findAllByUserId(userId);
        return getQuestionTitleDTOs(questionDocuments);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(Category category) {
        List<QuestionDocument> questionDocuments = questionRepository.findAllByCategory(category);
        return getQuestionTitleDTOs(questionDocuments);
    }

    @Override
    public QuestionTitleDTO[] getQuestions() {
        List<QuestionDocument> questionDocuments = questionRepository.findAll();
        return getQuestionTitleDTOs(questionDocuments);
    }

    @Override
    public boolean update(Integer questionId, String title, String symptom, String content) {
        QuestionDocument questionDocument = questionRepository.findById(String.valueOf(questionId)).orElse(null);
        if (questionDocument == null) {
            return false;
        }

        questionDocument.setTitle(title);
        questionDocument.setSymptom(symptom);
        questionDocument.setContent(content);
        questionRepository.save(questionDocument);
        return true;
    }

    @Override
    public boolean delete(int id) {
        QuestionDocument questionDocument = questionRepository.findById(String.valueOf(id)).orElse(null);
        if (questionDocument == null) {
            return false;
        }

        PersonalDataDocument personalData = personalDataRepository.findByQuestionId(questionDocument.getId());
        if (personalData != null) {
            personalDataRepository.delete(personalData);
        }

        bodyMappingRepository.deleteAll(bodyMappingRepository.findByQuestionId(questionDocument.getId()));
        questionRepository.delete(questionDocument);
        return true;
    }

    private QuestionTitleDTO[] getQuestionTitleDTOs(List<QuestionDocument> questionDocuments) {
        return questionDocuments.stream()
                .map(doc -> new QuestionTitleDTO(doc.getId(), doc.getTitle()))
                .toArray(QuestionTitleDTO[]::new);
    }

    private QuestionDTO getQuestionDTO(QuestionDocument q) {
        PersonalDataDocument personalData = personalDataRepository.findByQuestionId(q.getId());
        List<BodyPart> bodyParts = bodyMappingRepository.findByQuestionId(q.getId()).stream()
                .map(BodyPartMappingDocument::getBodyPart)
                .collect(Collectors.toList());

        return new QuestionDTO(q.getId(), q.getUserId(), q.getTitle(), q.getCategory(), q.getSymptom(), q.getContent(), bodyParts,
                new PersonalDataDTO(personalData.getAge(), personalData.getGender(), personalData.getDisease(), personalData.getMedication()));
    }
}