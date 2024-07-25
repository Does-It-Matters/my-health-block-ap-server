package com.example.myhealthblock.user;

import com.example.myhealthblock.user.dto.ResultSignIn;
import com.example.myhealthblock.user.dto.UserEntityDTO;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignIn;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignUp;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserEntityDTO, UserSignUp {
    private final UserOutport outport;

    public boolean signUp(RequestUserSignUp dto) {
        User user = outport.getUser(dto.getId());
        if (user == null)
            return outport.create(dto.getId(), dto.getPw(), dto.getRole());
        return false;
    }


    public ResultSignIn signIn(RequestUserSignIn dto) {
        User user = outport.getUser(dto.getId());
        ResultSignIn result = new ResultSignIn();

        if (user!=null && user.signIn(dto.getPw()))
            result.success(user.getRole(), user.getUid());

        return result;
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
