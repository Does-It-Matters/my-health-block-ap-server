//package com.example.myhealthblock.user.adapter.in.web;
//
//import com.example.myhealthblock.aop.LogExecutionTime;
//import com.example.myhealthblock.aop.LogTarget;
//import com.example.myhealthblock.jwt.JwtService;
//import com.example.myhealthblock.user.application.port.in.UserInport;
//import com.example.myhealthblock.user.domain.model.User;
//import com.example.myhealthblock.user.adapter.in.web.request.UserSignInRequest;
//import com.example.myhealthblock.user.adapter.in.web.request.UserUpdatePwRequest;
//import com.example.myhealthblock.user.adapter.in.web.response.ResultResponse;
//import com.example.myhealthblock.user.adapter.in.web.response.SignInResponse;
//import com.example.myhealthblock.user.adapter.in.web.response.SignInWithJwtResponse;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import lombok.RequiredArgsConstructor;
//
//import java.util.Map;
//
//@Tag(name = "User", description = "Endpoints for User")
//@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api")
//public class UserController {
//    private final UserInport userInport;
//    private final JwtService jwtService;
//
//    @Operation(summary = "로그인", description = "로그인 후 특정 역할 반환")
//    @PostMapping("/v2/sign-in")
//    public ResponseEntity<SignInResponse> signIn(@RequestBody UserSignInRequest body) {
//        SignInResponse response = userInport.signIn(body.toInportDTO()).getRequestBody();
//        return ResponseEntity.ok(response);
//    }
//
////    @Operation(summary = "로그인", description = "로그인 후 JWT 토큰 발급")
////    @PostMapping("/v3/sign-in")
////    public ResponseEntity<SignInWithJwtResponse> signInWithJWT(@RequestBody UserSignInRequest body) {
////        try {
////            User user = userInport.signInWithJWT(body);
////            Map<String, String> tokens = jwtService.generateTokens(user);
////
////            HttpHeaders headers = new HttpHeaders();
////            headers.add("Authorization", "Bearer " + tokens.get("accessToken"));
////
////            SignInWithJwtResponse response = new SignInWithJwtResponse(tokens.get("refreshToken"), user.getRole());
////            return ResponseEntity.ok().headers(headers).body(response);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SignInWithJwtResponse("Invalid credentials"));
////        }
////    }
//
//    @Operation(summary = "비밀번호 수정", description = "비밀번호 수정 <br>userId는 회원가입 아이디")
//    @PutMapping("/v2/user/{userId}/pw")
//    public ResponseEntity<ResultResponse> updatePw(@PathVariable String userId, @RequestBody UserUpdatePwRequest body) {
//        String result = userInport.changePw(userId, body.toInportDTO());
//        return  ResponseEntity.ok(new ResultResponse(result));
//    }
//}
