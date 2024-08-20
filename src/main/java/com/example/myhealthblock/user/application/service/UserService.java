package com.example.myhealthblock.user.application.service;

import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutport;
import com.example.myhealthblock.user.application.port.in.GetUserEntityDTO;
import com.example.myhealthblock.user.application.port.in.UserSignUp;
import com.example.myhealthblock.user.domain.dto.ResultSignIn;
import com.example.myhealthblock.user.domain.dto.UserEntityDTO;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignInRequest;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserEntityDTO, UserSignUp {
    private final UserOutport outport;

    public boolean signUp(UserSignUpRequest dto) {
        User user = outport.getUser(dto.getId());
        if (user == null)
            return outport.create(dto.getId(), dto.getPw(), dto.getRole());
        return false;
    }


    public ResultSignIn signIn(UserSignInRequest dto) {
        User user = outport.getUser(dto.getId());
        ResultSignIn result = new ResultSignIn();

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

    public String changePw(String userId, String oldPw, String newPw) {
        User user = outport.getUser(userId);
        if(user.changePw(oldPw, newPw)) {
            outport.updatePw(user.getUid(), user.getPw());
            return "success";
        }
        return "fail";
    }

    @Override
    public UserEntityDTO getUserEntityDTO(String userId) {
        return outport.getUserEntityDTO(userId);
    }
}
