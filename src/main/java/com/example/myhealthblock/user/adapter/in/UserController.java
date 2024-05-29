package com.example.myhealthblock.user.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignIn;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignUp;
import com.example.myhealthblock.user.adapter.in.request.RequestUserUpdatePw;
import com.example.myhealthblock.user.adapter.in.response.ResponseResult;
import com.example.myhealthblock.user.adapter.in.response.ResponseSignIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Tag(name = "User", description = "Endpoints for User")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

//    @Operation(summary = "테스트용 회원가입", description = "특정 역할로 회원가입이 아닌 일반 회원가입 테스트")
//    @PostMapping("/test/sign-up")
//    public String signUp(@RequestBody RequestUserSignUp body) {
//        return userService.signUp(body);
//    }

    @Operation(summary = "로그인", description = "로그인 후 특정 역할 반환")
    @PostMapping("/v1/sign-in")
    public ResponseEntity<ResponseSignIn> signIn(@RequestBody RequestUserSignIn body) {
//        try {
//            ResponseSignIn response = userService.signIn(body);
//            return ResponseEntity.ok(response); // 성공 시 HTTP 200 OK
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseSignIn("Invalid credentials")); // 실패 시 HTTP 401 Unauthorized
//        }
        return ResponseEntity.ok(userService.signIn(body).getRequestBody());
    }

    @Operation(summary = "비밀번호 수정", description = "비밀번호 수정 <br>userId는 회원가입 아이디")
    @PutMapping({"/v1/user/{userId}/pw", "/test-0/user/{userId}/pw"})
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
