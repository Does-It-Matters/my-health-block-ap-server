package com.example.myhealthblock.user.application.port.in;

import com.example.myhealthblock.user.adapter.in.web.request.RequestUserSignUp;

public interface UserSignUp {
    boolean signUp(RequestUserSignUp dto);
}
