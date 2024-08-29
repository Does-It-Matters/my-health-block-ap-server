package com.example.myhealthblock.question.adapter.in.web;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.question.application.port.in.QuestionInputPort;
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

/**
 * <b> 역할: Question 컨트롤러 클래스 </b>
 * <p>
 * - 질문 정보 관리 컨트톨러 <br>
 * </p>
 */
@Tag(name = "Question", description = "Endpoints for Question")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionInputPort questionInputPort;

    /**
     * <b> 역할: 질문 등록 메소드 </b>
     * <p>
     * - 요청 정보를 입력 포트에 맞게 변환 <br>
     * - 질문 등록 작업 수행에 대한 결과를 API 응답 포맷으로 변환 <br>
     * </p>
     *
     * @param body HTTP 요청 바디가 매핑된 객체
     * @return API 응답 포맷에 해당하는 객체
     */
    @Operation(summary = "질문 등록", description = "질문 등록")
    @PostMapping("/v3/question/enroll")
    public ResponseEntity<ResultResponse> enroll(@RequestBody QuestionEnrollRequest body) {
        ResultResponse response = new ResultResponse();
        String result = questionInputPort.enroll(body.toInputPortDTO());
        response.setResult(result);
        return ResponseEntity.ok(response);
    }

    /**
     * <b> 역할: 질문 제목 목록 조회 메소드 </b>
     * <p>
     * - 요청 정보를 입력 포트에 맞게 변환 <br>
     * - 질문 등록 작업 수행에 대한 결과를 API 응답 포맷으로 변환 <br>
     * * 조회 로직 <br>
     * 회원 Id 제공 : 회원 Id로 질문 목록 조회 <br>
     * 카테고리 제공 : 카테고리로 질문 목록 조회 <br>
     * 제공 정보 없는 경우 : 전체 질문 목록 조회 <br>
     * </p>
     *
     * @param category 게시판 카테고리 (선택적)
     * @param userId 조회할 회원의 식별자 (선택적)
     * @return 질문 목록이 포함된 API 응답 객체
     */
    @Operation(summary = "질문 목록 조회", description = "질문 식별자와 제목으로 목록 조회 <br>catetory는 게시판 카테고리<br>userId는 회원가입 아이디")
    @GetMapping("/v3/question/list")
    public ResponseEntity<QuestionListResponse> getTitles(@RequestParam(required = false) Category category, @RequestParam(required = false) Integer userId) {
        QuestionTitleDTO[] list = null;
        if (userId != null) {
            list = questionInputPort.getQuestions(userId);
        } else if (category != null){
            list = questionInputPort.getQuestions(category);
        } else {
            list = questionInputPort.getQuestions();
        }
        return ResponseEntity.ok(new QuestionListResponse(list));
    }

    /**
     * <b> 역할: 단건 질문 조회 메소드 </b>
     * <p>
     * - 질문 Id를 기반으로 단건 질문 정보 조회 <br>
     * - 조회 결과를 API 응답 포맷으로 변환 <br>
     * </p>
     *
     * @param questionId 조회할 질문의 식별자
     * @return 질문 정보가 포함된 API 응답 객체
     */
    @Operation(summary = "질문 조회", description = "하나의 질문 정보 조회 <br>{questionId}는 식별자 <br>질문 목록에서 선택한 하나의 질문 내용 조회")
    @GetMapping("/v3/question/{questionId}")
    public ResponseEntity<QuestionResponse> get(@PathVariable Integer questionId) {
        return ResponseEntity.ok(new QuestionResponse(questionInputPort.getQuestion(questionId)));
    }

    /**
     * <b> 역할: 질문 수정 메소드 </b>
     * <p>
     * - 질문 수정 작업 수행에 대한 결과를 API 응답 포맷으로 변환 <br>
     * </p>
     *
     * @param body HTTP 요청 바디가 매핑된 객체
     * @return API 응답 포맷에 해당하는 객체
     */
    @Operation(summary = "질문 수정", description = "특정 데이터만 수정")
    @PatchMapping("/v3/question")
    public ResponseEntity<ResultResponse> update(@RequestBody QuestionUpdateRequest body) {
        return ResponseEntity.ok(new ResultResponse(questionInputPort.update(body.getQuestionId(), body.getTitle(), body.getSymptom(), body.getContent())));
    }

    /**
     * <b> 역할: 질문 삭제 메소드 </b>
     * <p>
     * - 질문 Id를 기반으로 질문 삭제 작업 수행 <br>
     * - 질문 삭제 작업 수행에 대한 결과를 API 응답 포맷으로 변환 <br>
     * </p>
     *
     * @param questionId 삭제할 질문의 식별자
     * @return API 응답 포맷에 해당하는 객체
     */
    @Operation(summary = "질문 삭제", description = "질문 삭제 <br>{questionId}는 식별자")
    @DeleteMapping("/v3/question/{questionId}")
    public ResponseEntity<ResultResponse> delete(@PathVariable Integer questionId) {
        return ResponseEntity.ok(new ResultResponse(questionInputPort.delete(questionId)));
    }
}
