package com.example.myhealthblock.user.adapter.out.mybatis;

import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
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
        UserEntity entity = userMapper.findByUserId(id);
        if (entity == null) {
            return null;
        }
        return new User(entity.getId(), entity.getUserId(), entity.getPw(), entity.getRole());
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
}