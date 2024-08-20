package com.example.myhealthblock.user.application.service;

import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;
import com.example.myhealthblock.user.application.port.in.UserInport;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInportRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserUpdatePwInportRequest;
import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutport;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInportResponse;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignInRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserInport {
    private final UserOutport outport;

    @Override
    public boolean signUp(UserSignUpRequest dto) {
        User user = outport.getUser(dto.getId());
        if (user == null)
            return outport.create(dto.getId(), dto.getPw(), dto.getRole());
        return false;
    }


    public UserSignInInportResponse signIn(UserSignInInportRequest dto) {
        User user = outport.getUser(dto.getId());
        UserSignInInportResponse result = new UserSignInInportResponse();

        if (user!=null && user.signIn(dto.getPw()))
            result.success(user.getRole(), user.getUid());

        return result;
    }

    public User signInWithJWT(UserSignInRequest dto) throws Exception {
        User user = outport.getUser(dto.getId());

        if (user!=null && user.signIn(dto.getPw()))
            return user;
        throw new Exception("Invalid credentials");
    }

    public String changePw(String userId, UserUpdatePwInportRequest dto) {
        User user = outport.getUser(userId);
        if(user.changePw(dto.getOldPw(), dto.getNewPw())) {
            outport.updatePw(user.getUid(), user.getPw());
            return "success";
        }
        return "fail";
    }
}
