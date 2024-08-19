package com.example.myhealthblock.opinion.adapter.in.web;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.opinion.application.service.OpinionService;
import com.example.myhealthblock.opinion.adapter.in.web.request.RequestOpinionEnroll;
import com.example.myhealthblock.opinion.adapter.in.web.response.ResponseEnrollOpinion;
import com.example.myhealthblock.opinion.adapter.in.web.response.ResponseOpinions;
import com.example.myhealthblock.opinion.adapter.in.web.response.ResponseResult;
import com.example.myhealthblock.opinion.domain.dto.OpinionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Opinion", description = "Endpoints for opinion")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OpinionController {
    private final OpinionService opinionService;

    @Operation(summary = "의견 등록", description = "유저가 의견 등록")
    @PostMapping("/v2/opinion/enroll")
    public ResponseEntity<ResponseEnrollOpinion> enroll(@RequestBody RequestOpinionEnroll body) {
        return ResponseEntity.ok(new ResponseEnrollOpinion(opinionService.enroll(body)));
    }

    @Operation(summary = "의견들 조회", description = "유저가 의견들 조회 <br>questionId는 질문 식별자로, 입력 시 특정 질문에 대한 의견들 조회 <br>userId는 회원가입 시 등록한 아이디로, 입력 시 본인이 등록한 의견들 조회<br>둘 중 하나만 입력")
    @GetMapping("/v2/opinions")
    public ResponseEntity<ResponseOpinions> getOpinions(@RequestParam(required = false) Integer questionId, @RequestParam(required = false) String userId) {
        OpinionDTO[] list = null;
        if (userId != null) {
            list = opinionService.getOpinions(userId);
        } else if (questionId != null){
            list = opinionService.getOpinions(questionId);
        }
        return ResponseEntity.ok(new ResponseOpinions(list));
    }

    @Operation(summary = "의견 삭제", description = "유저가 의견 삭제 <br>{opinionId}는 식별자")
    @DeleteMapping("/v2/opinion/{opinionId}")
    public ResponseEntity<ResponseResult> delete(@PathVariable Integer opinionId) {
        return ResponseEntity.ok(new ResponseResult(opinionService.delete(opinionId)));
    }
}
