package com.example.myhealthblock.question.application.service;

import com.example.myhealthblock.patient.application.port.in.GetPatientEntityDTO;
import com.example.myhealthblock.patient.domain.dto.PatientEntityDTO;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.application.port.in.GetQuestionEntityDTO;
import com.example.myhealthblock.question.application.port.out.QuestionOutport;
import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import com.example.myhealthblock.question.adapter.in.web.request.RequestQuestionEnroll;
import com.example.myhealthblock.question.domain.dto.QuestionEntityDTO;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService implements GetQuestionEntityDTO {
    private final QuestionOutport outport;
    private final GetPatientEntityDTO patientInport;

    public String enroll(RequestQuestionEnroll dto) {
        PatientEntityDTO patientDto = patientInport.getPatientEntityDTO(dto.getUserId());
        boolean result = outport.create(patientDto.getEntity(), dto.getTitle(), dto.getCategory(), dto.getSymptom(), dto.getContent(), dto.getBodyParts(), dto.getPersonalData());

        return result ? "success" : "fail";
    }

    public QuestionDTO getQuestion(Integer questionId) {
        return outport.getQuestion(questionId);
    }

    public QuestionTitleDTO[] getQuestions(String userId) {
        PatientEntityDTO patientDto = patientInport.getPatientEntityDTO(userId);
        return outport.getQuestions(patientDto.getEntity());
    }

    public QuestionTitleDTO[] getQuestions(Category category) {
        return outport.getQuestions(category);
    }

    public QuestionTitleDTO[] getQuestions() {
        return outport.getQuestions();
    }

    @Override
    public QuestionEntityDTO getQuestionEntityDTO(int questionId) {
        return outport.getQuestionEntityDTO(questionId);
    }

    public String update(Integer questionId, String title, String symptom, String content) {
        boolean result = outport.update(questionId, title, symptom, content);
        return result ? "success" : "fail";
    }

    public String delete(Integer questionId) {
        boolean result = outport.delete(questionId);
        return result ? "success" : "fail";
    }

//    성능 측정 대상 - 질문 내용들까지 보낼 때와 제목만 보낼 때
//    public QuestionDTO[] getQuestionsWithDetail() {
//        return outport.getQuestionsWithDetail();
//    }

//    public QuestionDTO[] getQuestionsWithDetail(String userId) {
//        PatientEntityDTO patientDto = patientInport.getPatientEntityDTO(userId);
//        return outport.getQuestionsWithDetail(patientDto.getEntity());
//    }
//
//    public QuestionDTO[] getQuestionsWithDetail(Category category) {
//        return outport.getQuestionsWithDetail(category);
//    }
//
//    public QuestionDTO[] getQuestionsWithDetailByOpinionUserId(String opinionUserId) {
//        return outport.getQuestionsWithDetailByOpinionUserId(opinionUserId);
//    }
}
