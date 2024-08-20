package com.example.myhealthblock.user.application.port.in;

import com.example.myhealthblock.user.adapter.in.web.request.UserSignInRequest;
import com.example.myhealthblock.user.domain.dto.ResultSignIn;
import com.example.myhealthblock.user.domain.model.User;

public interface UserInport extends UserSignUp, GetUserEntityDTO{
    ResultSignIn signIn(UserSignInRequest dto);
    User signInWithJWT(UserSignInRequest dto) throws Exception;
    String changePw(String userId, String oldPw, String newPw);
}
