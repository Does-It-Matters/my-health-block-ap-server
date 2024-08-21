//package com.example.myhealthblock.question.application.port.in;
//
//import com.example.myhealthblock.question.adapter.in.web.request.QuestionEnrollRequest;
//import com.example.myhealthblock.question.application.port.in.dto.QuestionEnrollInportRequest;
//import com.example.myhealthblock.question.common.Category;
//import com.example.myhealthblock.question.domain.dto.QuestionDTO;
//import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
//
//public interface QuestionInport {
//    String enroll(QuestionEnrollInportRequest dto);
//    QuestionDTO getQuestion(Integer questionId);
//    QuestionTitleDTO[] getQuestions(int userId);
//    QuestionTitleDTO[] getQuestions(Category category);
//    QuestionTitleDTO[] getQuestions();
//    String update(Integer questionId, String title, String symptom, String content);
//    String delete(Integer questionId);
//}
