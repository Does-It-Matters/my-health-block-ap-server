package com.example.myhealthblock.user.adapter.out.database.mybatis;

import java.time.LocalDateTime;

import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import com.example.myhealthblock.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutputPort {

    private final UserMapper userMapper;

    @Override
    public boolean create(String id, String pw, String role) {
        UserEntity user = new UserEntity();
        user.setUserId(id);
        user.setPw(pw);
        user.setRole(role);
        user.setCreateDate(LocalDateTime.now());
        user.setLastEditDate(LocalDateTime.now());
        userMapper.insertUser(user);
        return true;
    }

    @Override
    public User getUser(String id) {
        UserEntity userEntity = userMapper.findByUserId(id);
        if (userEntity == null) {
            return null;
        }
        return new User(getStringUserId(userEntity.getId()), userEntity.getUserId(), userEntity.getPw(), userEntity.getRole());
    }

    @Override
    public boolean updatePw(String userId, String pw) {
        UserEntity entity = userMapper.findByUserId(userId);
        if (entity != null) {
            entity.setPw(pw);
            entity.setLastEditDate(LocalDateTime.now());
            userMapper.updatePw(userId, pw, entity.getLastEditDate());
            return true;
        }
        return false;
    }

    // private UserDTO getUserDTO(UserEntity u) {
    //     return new UserDTO(getStringUserId(u.getId()), u.getUserId(), u.getPw(), u.getRole());
    // }

    private String getStringUserId(int userId) {
        return String.valueOf(userId);
    }
}