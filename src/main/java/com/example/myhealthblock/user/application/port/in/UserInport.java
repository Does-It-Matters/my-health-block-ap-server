package com.example.myhealthblock.user.application.port.in;

import com.example.myhealthblock.user.adapter.in.web.request.UserSignInRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInportRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserUpdatePwInportRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInportResponse;
import com.example.myhealthblock.user.domain.model.User;

public interface UserInport extends UserSignUp {
    UserSignInInportResponse signIn(UserSignInInportRequest dto);
    User signInWithJWT(UserSignInRequest dto) throws Exception;
    String changePw(String userId, UserUpdatePwInportRequest dto);
}
