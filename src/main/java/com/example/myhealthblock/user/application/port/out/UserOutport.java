package com.example.myhealthblock.user.application.port.out;

import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.domain.dto.UserEntityDTO;

public interface UserOutport {
    public boolean create(String id, String pw, String role);
    public User getUser(String id);
    public UserEntityDTO getUserEntityDTO(String userId);
    public boolean updatePw(String userId, String pw);
}
