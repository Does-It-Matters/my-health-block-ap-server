package com.example.myhealthblock.question.adapter.out;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.adapter.out.PatientEntity;
import com.example.myhealthblock.patient.adapter.out.PatientRepository;
import com.example.myhealthblock.question.Category;
import com.example.myhealthblock.question.QuestionOutport;
import com.example.myhealthblock.question.adapter.out.bodypart.BodyMappingRepository;
import com.example.myhealthblock.question.adapter.out.bodypart.BodyPart;
import com.example.myhealthblock.question.adapter.out.bodypart.BodyPartMappingEntity;
import com.example.myhealthblock.question.dto.PersonalDataDTO;
import com.example.myhealthblock.question.dto.QuestionDTO;
import com.example.myhealthblock.question.adapter.out.personaldata.PersonalDataEntity;
import com.example.myhealthblock.question.adapter.out.personaldata.PersonalDataRepository;

import com.example.myhealthblock.question.dto.QuestionEntityDTO;
import com.example.myhealthblock.question.dto.QuestionTitleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class QuestionAdapter implements QuestionOutport {
    private final QuestionRepository questionRepository;
    private final PatientRepository patientRepository;
    private final PersonalDataRepository personalDataRepository;
    private final BodyMappingRepository bodyMappingRepository;

    @Override
    public boolean create(PatientEntity patient, String title, Category category, String symptom, String content, List<BodyPart> bodyParts, PersonalDataDTO personalData) {
        QuestionEntity question = new QuestionEntity(patient, title, category, symptom, content);
        questionRepository.save(question);

        insertPatient(question, patient);
        insertBodyParts(question, bodyParts);
        insertPersonalData(question, personalData);

        return true;
    }

    @Override
    public QuestionDTO getQuestion(int id) {
        QuestionEntity questionEntity = getQuestionEntity(id);
        if (questionEntity == null) {
            return null;
        }

        return getQuestionDTO(questionEntity);
    }

    @Override
    public QuestionTitleDTO[] getQuestions(PatientEntity patient) {
        return getQuestionTitleDTOs(this.questionRepository.findAllByPatient(patient));
    }

    @Override
    public QuestionTitleDTO[] getQuestions(Category category) {
        return getQuestionTitleDTOs(this.questionRepository.findAllByCategory(category));
    }

    @Override
    public QuestionTitleDTO[] getQuestions() {
        return getQuestionTitleDTOs(this.questionRepository.findAll());
    }

    @Override
    public QuestionEntityDTO getQuestionEntityDTO(int id) {
        return new QuestionEntityDTO(getQuestionEntity(id));
    }

    @Override
    public boolean update(Integer questionId, String title, String symptom, String content) {
        QuestionEntity question = getQuestionEntity(questionId);
        question.setTitle(title);
        question.setSymptom(symptom);
        question.setContent(content);
        questionRepository.save(question);

        return true;
    }

    @Override
    public boolean delete(int id) {
        QuestionEntity questionEntity = getQuestionEntity(id);

        PersonalDataEntity personalData = personalDataRepository.findByQuestion(questionEntity);
        if (personalData != null) {
            personalDataRepository.delete(personalData);
        }

        if (questionEntity == null) {
            return false;
        }

        deleteQuestion(questionEntity);
        return true;
    }

//    @Override
//    public QuestionDTO[] getQuestionsWithDetail() {
//        return getQuestionDTOs(this.questionRepository.findAll());
//    }
//
//    @Override
//    public QuestionDTO[] getQuestionsWithDetail(PatientEntity patient) {
//        return getQuestionDTOs(this.questionRepository.findAllByPatient(patient));
//    }
//
//    @Override
//    public QuestionDTO[] getQuestionsWithDetail(Category category) {
//        return getQuestionDTOs(this.questionRepository.findAllByCategory(category));
//    }
//
//    @Override
//    public QuestionDTO[] getQuestionsWithDetailByOpinionUserId(String opinionUserId) {
//        return getQuestionDTOs(questionRepository.findByOpinionsUserUserId(opinionUserId));
//    }

    private void insertPatient(QuestionEntity question, PatientEntity patient) {
        patient.addQuestion(question);
        patientRepository.save(patient);
    }

    private void insertBodyParts(QuestionEntity question, List<BodyPart> bodyParts) {
        if (bodyParts == null) {
            return;
        }
        for (BodyPart bodyPart : bodyParts) {
            bodyMappingRepository.save(new BodyPartMappingEntity(question, bodyPart));
        }
    }

    private void insertPersonalData(QuestionEntity question, PersonalDataDTO personalData) {
        if (personalData != null) {
            personalDataRepository.save(getPersonalDataEntity(question, personalData));
        }
    }

    private PersonalDataEntity getPersonalDataEntity(QuestionEntity question, PersonalDataDTO personalData) {
        PersonalDataEntity personalDataEntity = new PersonalDataEntity();
        personalDataEntity.setQuestion(question);
        personalDataEntity.setAge(personalData.getAge());
        personalDataEntity.setGender(personalData.getGender());
        personalDataEntity.setDisease(personalData.getDisease());
        personalDataEntity.setMedication(personalData.getMedication());

        return personalDataEntity;
    }

    private QuestionEntity getQuestionEntity(int id) {
        return this.questionRepository.findById(id).orElse(null);
    }

    private QuestionTitleDTO[] getQuestionTitleDTOs(List<QuestionEntity> questionEntities) {
        return questionEntities.stream()
                .map(this::getQuestionTitleDTO)
                .toArray(QuestionTitleDTO[]::new);
    }

    private QuestionDTO[] getQuestionDTOs(List<QuestionEntity> questionEntities) {
        return questionEntities.stream()
                .map(this::getQuestionDTO)
                .toArray(QuestionDTO[]::new);
    }

    private QuestionDTO getQuestionDTO(QuestionEntity questionEntity) {
        PersonalDataDTO personalData = getPersonalDataDTO(personalDataRepository.findByQuestion(questionEntity));
        List<BodyPart> bodyParts = getBodyParts(questionEntity);

        return new QuestionDTO(
                questionEntity.getId(),
                questionEntity.getPatient().getUserId(),
                questionEntity.getTitle(),
                questionEntity.getCategory(),
                questionEntity.getSymptom(),
                questionEntity.getContent(),
                bodyParts,
                personalData
        );
    }

    private QuestionTitleDTO getQuestionTitleDTO(QuestionEntity questionEntity) {
        return new QuestionTitleDTO(questionEntity.getId(), questionEntity.getTitle());
    }

    private PersonalDataDTO getPersonalDataDTO(PersonalDataEntity personalDataEntity) {
        if (personalDataEntity == null) {
            return null;
        }

        PersonalDataDTO personalData = new PersonalDataDTO();

        personalData.setAge(personalDataEntity.getAge());
        personalData.setGender(personalDataEntity.getGender());
        personalData.setDisease(personalDataEntity.getDisease());
        personalData.setMedication(personalDataEntity.getMedication());

        return personalData;
    }

    private List<BodyPart> getBodyParts(QuestionEntity questionEntity) {
        return this.bodyMappingRepository.findByQuestion(questionEntity)
                .stream()
                .map(BodyPartMappingEntity::getBodyPart)
                .collect(Collectors.toList());
    }

    private void deleteQuestion(QuestionEntity questionEntity) {
        this.questionRepository.delete(questionEntity);
    }
}