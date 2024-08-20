package com.example.myhealthblock.user;

import com.example.myhealthblock.user.application.service.UserService;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void testSignUpIntegration() {
        // Given
        UserSignUpRequest dto = new UserSignUpRequest();
        dto.setId("user");
        dto.setPw("password");
        dto.setRole("PATIENT");

        // When
        boolean result = userService.signUp(dto);

        // Then
        assertTrue(result);
    }
}
