package com.example.myhealthblock.user.adapter.out.persistence;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class UserPersistenceAdapter implements UserOutport {
    private final UserRepository userRepository;

    @Override
    public boolean create(String id, String pw, String role) {
        UserEntity q = new UserEntity(id, pw, role);
        this.userRepository.save(q);

        return true;
    }

    @Override
    public User getUser(String id) {
        UserEntity entity = getUserEntity(id);

        return (entity != null) ? new User(entity.getId(), entity.getUserId(), entity.getPw(), entity.getRole()) : null;
    }

    @Override
    public boolean updatePw(String userId, String pw) {
        UserEntity userEntity = getUserEntity(userId);
        if (userEntity != null) {
            userEntity.setPw(pw);
            userRepository.save(userEntity);
            return true;
        }
        return false;
    }

    private UserEntity getUserEntity(String id) {
        return this.userRepository.findByUserId(id);
    }
}
