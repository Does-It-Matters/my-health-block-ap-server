package com.example.myhealthblock.question.adapter.in.web;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.question.application.port.in.QuestionInport;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.adapter.in.web.request.QuestionEnrollRequest;
import com.example.myhealthblock.question.adapter.in.web.request.QuestionUpdateRequest;
import com.example.myhealthblock.question.adapter.in.web.response.QuestionListResponse;
import com.example.myhealthblock.question.adapter.in.web.response.QuestionResponse;
import com.example.myhealthblock.question.adapter.in.web.response.ResultResponse;
import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
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
    private final QuestionInport questionInport;

    @Operation(summary = "질문 등록", description = "질문 등록")
    @PostMapping("/v2/question/enroll")
    public ResponseEntity<ResultResponse> enroll(@RequestBody QuestionEnrollRequest body) {
        ResultResponse response = new ResultResponse();
        String result = questionInport.enroll(body.toInportDTO());
        response.setResult(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "질문 목록 조회", description = "질문 식별자와 제목으로 목록 조회 <br>catetory는 게시판 카테고리<br>userId는 회원가입 아이디")
    @GetMapping("/v2/question/list")
    public ResponseEntity<QuestionListResponse> getTitles(@RequestParam(required = false) Category category, @RequestParam(required = false) Integer userId) {
        QuestionTitleDTO[] list = null;
        if (userId != null) {
            list = questionInport.getQuestions(userId);
        } else if (category != null){
            list = questionInport.getQuestions(category);
        } else {
            list = questionInport.getQuestions();
        }
        return ResponseEntity.ok(new QuestionListResponse(list));
    }

    @Operation(summary = "질문 조회", description = "하나의 질문 정보 조회 <br>{questionId}는 식별자 <br>질문 목록에서 선택한 하나의 질문 내용 조회")
    @GetMapping("/v2/question/{questionId}")
    public ResponseEntity<QuestionResponse> get(@PathVariable Integer questionId) {
        return ResponseEntity.ok(new QuestionResponse(questionInport.getQuestion(questionId)));
    }

    @Operation(summary = "질문 수정", description = "특정 데이터만 수정")
    @PatchMapping("/v2/question")
    public ResponseEntity<ResultResponse> update(@RequestBody QuestionUpdateRequest body) {
        return ResponseEntity.ok(new ResultResponse(questionInport.update(body.getQuestionId(), body.getTitle(), body.getSymptom(), body.getContent())));
    }

    @Operation(summary = "질문 삭제", description = "질문 삭제 <br>{questionId}는 식별자")
    @DeleteMapping("/v2/question/{questionId}")
    public ResponseEntity<ResultResponse> delete(@PathVariable Integer questionId) {
        return ResponseEntity.ok(new ResultResponse(questionInport.delete(questionId)));
    }
}
