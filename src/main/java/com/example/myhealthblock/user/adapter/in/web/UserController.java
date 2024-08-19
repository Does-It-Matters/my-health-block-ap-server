package com.example.myhealthblock.user.adapter.in.web;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.jwt.JwtService;
import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.service.UserService;
import com.example.myhealthblock.user.adapter.in.web.request.RequestUserSignIn;
import com.example.myhealthblock.user.adapter.in.web.request.RequestUserUpdatePw;
import com.example.myhealthblock.user.adapter.in.web.response.ResponseResult;
import com.example.myhealthblock.user.adapter.in.web.response.ResponseSignIn;
import com.example.myhealthblock.user.adapter.in.web.response.ResponseSignInWithJwt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@Tag(name = "User", description = "Endpoints for User")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    @Operation(summary = "로그인", description = "로그인 후 특정 역할 반환")
    @PostMapping("/v2/sign-in")
    public ResponseEntity<ResponseSignIn> signIn(@RequestBody RequestUserSignIn body) {
//        try {
//            ResponseSignIn response = userService.signIn(body);
//            return ResponseEntity.ok(response); // 성공 시 HTTP 200 OK
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseSignIn("Invalid credentials")); // 실패 시 HTTP 401 Unauthorized
//        }
        return ResponseEntity.ok(userService.signIn(body).getRequestBody());
    }

    @Operation(summary = "로그인", description = "로그인 후 JWT 토큰 발급")
    @PostMapping("/v3/sign-in")
    public ResponseEntity<ResponseSignInWithJwt> signInWithJWT(@RequestBody RequestUserSignIn body) {
        try {
            User user = userService.signInWithJWT(body);
            Map<String, String> tokens = jwtService.generateTokens(user);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + tokens.get("accessToken"));

            ResponseSignInWithJwt response = new ResponseSignInWithJwt(tokens.get("refreshToken"), user.getRole());
            return ResponseEntity.ok().headers(headers).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseSignInWithJwt("Invalid credentials"));
        }
    }

    @Operation(summary = "비밀번호 수정", description = "비밀번호 수정 <br>userId는 회원가입 아이디")
    @PutMapping("/v2/user/{userId}/pw")
    public ResponseEntity<ResponseResult> updatePw(@PathVariable String userId, @RequestBody RequestUserUpdatePw body) {
//        boolean pwChanged = userService.changePw(userId, body.getOldPw(), body.getNewPw());
//        if (pwChanged) {
//            return ResponseEntity.ok(new ResponseResult("Password successfully updated."));
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseResult("Failed to update password."));
//        }
        return  ResponseEntity.ok(new ResponseResult(userService.changePw(userId, body.getOldPw(), body.getNewPw())));
    }
}
