//package com.example.myhealthblock.opinion.adapter.in.web;
//
//import com.example.myhealthblock.aop.LogExecutionTime;
//import com.example.myhealthblock.aop.LogTarget;
//import com.example.myhealthblock.opinion.application.port.in.OpinionInport;
//import com.example.myhealthblock.opinion.adapter.in.web.request.OpinionEnrollRequest;
//import com.example.myhealthblock.opinion.adapter.in.web.response.EnrollOpinionResponse;
//import com.example.myhealthblock.opinion.adapter.in.web.response.OpinionsResponse;
//import com.example.myhealthblock.opinion.adapter.in.web.response.ResultResponse;
//import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInportDTO;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * <b> 역할: 의견 관련 컨트롤러 </b>
// * <br>- 의견 관리
// */
//@Tag(name = "Opinion", description = "Endpoints for opinion")
//@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api")
//public class OpinionController {
//    private final OpinionInport opinionInport;
//
//    /**
//     * <b> 역할: 의견 등록 메소드 </b>
//     *
//     * @param body 의견 등록 HTTP 요청 바디 데이터
//     * @return 의견 등록 응답
//     */
//    @Operation(summary = "의견 등록", description = "유저가 의견 등록")
//    @PostMapping("/v2/opinion/enroll")
//    public ResponseEntity<EnrollOpinionResponse> enroll(@RequestBody OpinionEnrollRequest body) {
//        OpinionInportDTO dto = opinionInport.enroll(body.toInportDTO());
//        return ResponseEntity.ok(new EnrollOpinionResponse(dto));
//    }
//
//    /**
//     * <b> 역할: 여러 의견 조회 메소드 </b>
//     *
//     * @param questionId 질문 식별자
//     * @param userId 회원가입 시 등록한 아이디
//     * @return 여러 의견
//     */
//    @Operation(summary = "의견들 조회", description = "유저가 의견들 조회 <br>questionId는 질문 식별자로, 입력 시 특정 질문에 대한 의견들 조회 <br>userId는 회원가입 시 등록한 아이디로, 입력 시 본인이 등록한 의견들 조회<br>둘 중 하나만 입력")
//    @GetMapping("/v2/opinions")
//    public ResponseEntity<OpinionsResponse> getOpinions(@RequestParam(required = false) Integer questionId, @RequestParam(required = false) Integer userId) {
//        OpinionInportDTO[] list = getOpinionDTOs(questionId, userId);
//        return ResponseEntity.ok(new OpinionsResponse(list));
//    }
//
//    /**
//     * <b> 역할: 상황에 따른 의견 조회 메소드 </b>
//     * - userId가 있으면 해당 사용자 의견 조회
//     * - questionId가 있으면 해당 질문에 대한 의견 조회
//     *
//     * @param questionId 질문 식별자
//     * @param userId 회원가입 시 등록한 아이디
//     * @return 여러 의견
//     */
//    private OpinionInportDTO[] getOpinionDTOs(Integer questionId, Integer userId) {
//        OpinionInportDTO[] list = null;
//        if (userId != null) {
//            list = opinionInport.getOpinionsByUserId(userId);
//        } else if (questionId != null){
//            list = opinionInport.getOpinionsByQuestionId(questionId);
//        }
//        return list;
//    }
//
//    /**
//     * <b> 역할: 의견 삭제 메소드 </b>
//     *
//     * @param opinionId 삭제할 의견 아이디
//     * @return 회원가입 응답
//     */
//    @Operation(summary = "의견 삭제", description = "유저가 의견 삭제 <br>{opinionId}는 식별자")
//    @DeleteMapping("/v2/opinion/{opinionId}")
//    public ResponseEntity<ResultResponse> delete(@PathVariable Integer opinionId) {
//        String result = opinionInport.delete(opinionId);
//        return ResponseEntity.ok(new ResultResponse(result));
//    }
//}
