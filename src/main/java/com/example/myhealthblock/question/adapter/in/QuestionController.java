package com.example.myhealthblock.question.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.question.Category;
import com.example.myhealthblock.question.QuestionService;
import com.example.myhealthblock.question.adapter.in.request.RequestQuestionEnroll;
import com.example.myhealthblock.question.adapter.in.request.RequestQuestionUpdate;
import com.example.myhealthblock.question.adapter.in.response.ResponseQuestionList;
import com.example.myhealthblock.question.adapter.in.response.ResponseQuestion;
import com.example.myhealthblock.question.adapter.in.response.ResponseResult;
import com.example.myhealthblock.question.dto.QuestionTitleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Tag(name = "Question", description = "Endpoints for Question")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    @Operation(summary = "질문 등록", description = "질문 등록")
    @PostMapping("/v2/question/enroll")
    public ResponseEntity<ResponseResult> enroll(@RequestBody RequestQuestionEnroll body) {
        ResponseResult response = new ResponseResult();
        response.setResult(questionService.enroll(body));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "질문 목록 조회", description = "질문 식별자와 제목으로 목록 조회 <br>catetory는 게시판 카테고리<br>userId는 회원가입 아이디")
    @GetMapping("/v2/question/list")
    public ResponseEntity<ResponseQuestionList> getTitles(@RequestParam(required = false) Category category, @RequestParam(required = false) String userId) {
        QuestionTitleDTO[] list = null;
        if (userId != null) {
            list = questionService.getQuestions(userId);
        } else if (category != null){
            list = questionService.getQuestions(category);
        } else {
            list = questionService.getQuestions();
        }
        return ResponseEntity.ok(new ResponseQuestionList(list));
    }

    @Operation(summary = "질문 조회", description = "하나의 질문 정보 조회 <br>{questionId}는 식별자 <br>질문 목록에서 선택한 하나의 질문 내용 조회")
    @GetMapping("/v2/question/{questionId}")
    public ResponseEntity<ResponseQuestion> get(@PathVariable Integer questionId) {
        return ResponseEntity.ok(new ResponseQuestion(questionService.getQuestion(questionId)));
    }

    @Operation(summary = "질문 수정", description = "특정 데이터만 수정")
    @PatchMapping("/v2/question")
    public ResponseEntity<ResponseResult> update(@RequestBody RequestQuestionUpdate body) {
        return ResponseEntity.ok(new ResponseResult(questionService.update(body.getQuestionId(), body.getTitle(), body.getSymptom(), body.getContent())));
    }

    @Operation(summary = "질문 삭제", description = "질문 삭제 <br>{questionId}는 식별자")
    @DeleteMapping("/v2/question/{questionId}")
    public ResponseEntity<ResponseResult> delete(@PathVariable Integer questionId) {
        return ResponseEntity.ok(new ResponseResult(questionService.delete(questionId)));
    }

//    @Operation(summary = "질문들 조회", description = "질문들 내용까지 함께 조회")
//    @GetMapping("/v1/question")
//    public ResponseEntity<ResponseQuestions> getQuestions(@RequestParam(required = false) Category category, @RequestParam(required = false) String userId, @RequestParam(required = false) String opinionUserId) {
//        ResponseQuestions response  = new ResponseQuestions();
//        QuestionDTO[] list = null;
//        if (userId != null) {
//            list = questionService.getQuestionsWithDetail(userId);
//        } else if (category == Category.ENTIRE){
//            list = questionService.getQuestionsWithDetail();
//        } else if (category != null){
//            list = questionService.getQuestionsWithDetail(category);
//        } else if (opinionUserId != null) {
//            list = questionService.getQuestionsWithDetailByOpinionUserId(opinionUserId);
//        } else {
//            list = questionService.getQuestionsWithDetail();
//        }
//        response.setQuestions(list);
//        return ResponseEntity.ok(response);
//    }
}
