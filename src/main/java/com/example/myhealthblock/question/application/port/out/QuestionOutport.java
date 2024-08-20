package com.example.myhealthblock.question.application.port.out;

import com.example.myhealthblock.patient.adapter.out.persistence.PatientEntity;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.adapter.out.persistence.bodypart.BodyPart;
import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.domain.dto.QuestionEntityDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;

import java.util.List;

public interface QuestionOutport {
    public boolean create(PatientEntity patient, String title, Category Category, String symptom, String content, List<BodyPart> bodyParts, PersonalDataDTO personalData);
    public QuestionDTO getQuestion(int id);
    public boolean delete(int id);
    public QuestionTitleDTO[] getQuestions(PatientEntity patient);
    public QuestionTitleDTO[] getQuestions(Category category);
    public QuestionTitleDTO[] getQuestions();
    public QuestionEntityDTO getQuestionEntityDTO(int id);
    public boolean update(Integer questionId, String title, String symptom, String content);
//    public QuestionDTO[] getQuestionsWithDetail();
//    public QuestionDTO[] getQuestionsWithDetail(PatientEntity patient);
//    public QuestionDTO[] getQuestionsWithDetail(Category category);
//    public QuestionDTO[] getQuestionsWithDetailByOpinionUserId(String opinionUserId);
}
