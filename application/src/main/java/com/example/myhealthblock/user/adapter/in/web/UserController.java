package com.example.myhealthblock.user.adapter.in.web;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
//import com.example.myhealthblock.jwt.JwtService;
import com.example.myhealthblock.user.adapter.in.web.response.UserSignInResponse;
import com.example.myhealthblock.user.application.port.in.UserInputPort;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortResponse;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignInRequest;
import com.example.myhealthblock.user.adapter.in.web.request.UserUpdatePwRequest;
import com.example.myhealthblock.user.adapter.in.web.response.UserUpdatePwResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: User 컨트롤러 클래스 </b>
 * <p>
 * - 사용자 회원 정보 관리 컨트톨러 <br>
 * </p>
 */
@Tag(name = "User", description = "Endpoints for User")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserInputPort userInputPort;
//    private final JwtService jwtService;

    /**
     * <b> 역할: 로그인 메소드 </b>
     * <p>
     * - 요청 정보를 입력 포트에 맞게 변환 <br>
     * - 로그인 작업 수행에 대한 결과를 API 응답 포맷으로 변환 <br>
     *
     * @param body HTTP 요청 바디가 매핑된 객체
     * @return API 응답 포맷에 해당하는 객체
     * </p>
     */
    @Operation(summary = "로그인", description = "로그인 후 특정 역할 반환")
    @PostMapping("/v3/sign-in")
    public ResponseEntity<UserSignInResponse> signIn(@RequestBody UserSignInRequest body) {
        UserSignInInputPortResponse result = userInputPort.signIn(body.toInputPortDTO());
        UserSignInResponse response = new UserSignInResponse(result.getRole(), result.getId());
        return ResponseEntity.ok(response);
    }

//    @Operation(summary = "로그인", description = "로그인 후 JWT 토큰 발급")
//    @PostMapping("/v3/sign-in")
//    public ResponseEntity<SignInWithJwtResponse> signInWithJWT(@RequestBody UserSignInRequest body) {
//        try {
//            User user = userInport.signInWithJWT(body);
//            Map<String, String> tokens = jwtService.generateTokens(user);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorization", "Bearer " + tokens.get("accessToken"));
//
//            SignInWithJwtResponse response = new SignInWithJwtResponse(tokens.get("refreshToken"), user.getRole());
//            return ResponseEntity.ok().headers(headers).body(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SignInWithJwtResponse("Invalid credentials"));
//        }
//    }

    /**
     * <b> 역할: 비밀번호 수정 메소드 </b>
     * <p>
     * - 요청 정보를 입력 포트에 맞게 변환 <br>
     * - 로그인 작업 수행에 대한 결과를 API 응답 포맷으로 변환 <br>
     *
     * @param body HTTP 요청 바디가 매핑된 객체
     * @return API 응답 포맷에 해당하는 객체
     * </p>
     */
    @Operation(summary = "비밀번호 수정", description = "비밀번호 수정 <br>userId는 회원가입 아이디")
    @PutMapping("/v3/user/{userId}/pw")
    public ResponseEntity<UserUpdatePwResponse> updatePw(@PathVariable String userId, @RequestBody UserUpdatePwRequest body) {
        String result = userInputPort.changePw(userId, body.toInputPortDTO());
        return  ResponseEntity.ok(new UserUpdatePwResponse(result));
    }
}
