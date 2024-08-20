package com.example.myhealthblock.user;

import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutport;
import com.example.myhealthblock.user.application.service.UserService;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;
import com.example.myhealthblock.user.adapter.out.persistence.UserEntity;
import com.example.myhealthblock.user.domain.dto.UserEntityDTO;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceJUnitTest {
    @Test
    void testSignUp_Success() {
        // Given
        UserOutport outport = new FakeUserOutport();
        UserService userService = new UserService(outport);
        UserSignUpRequest dto = new UserSignUpRequest();
        dto.setId("user");
        dto.setPw("password");
        dto.setRole("USER");

        // When
        boolean result = userService.signUp(dto);

        // Then
        assertTrue(result);
    }

    @Test
    void testSignUp_Fail_UserAlreadyExists() {
        // Given
        UserOutport outport = new FakeUserOutport();
        UserService userService = new UserService(outport);
        UserSignUpRequest dto = new UserSignUpRequest();
        dto.setId("user");
        dto.setPw("password");
        dto.setRole("PATIENT");

        // When
        outport.create("user", "password", "PATIENT");
        boolean result = userService.signUp(dto);

        // Then
        assertFalse(result);
    }

    private static class FakeUserOutport implements UserOutport {
        private final Map<String, User> users = new HashMap<>();

        @Override
        public boolean create(String id, String pw, String role) {
            if (users.containsKey(id)) {
                return false;
            }
            users.put(id, new User(null, id, pw, role));
            return true;
        }

        @Override
        public User getUser(String id) {
            return users.get(id);
        }

        @Override
        public UserEntityDTO getUserEntityDTO(String userId) {
            User user = users.get(userId);
            return user != null ? new UserEntityDTO(new UserEntity(userId, user.getPw(), user.getRole())) : null;
        }

        @Override
        public boolean updatePw(String userId, String pw) {
            User user = users.get(userId);
            if (user != null) {
                user.setPw(pw);
                return true;
            }
            return false;
        }
    }
}
