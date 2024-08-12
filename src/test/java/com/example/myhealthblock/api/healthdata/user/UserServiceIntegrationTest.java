package com.example.myhealthblock.api.healthdata.user;

import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignUp;
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
        RequestUserSignUp dto = new RequestUserSignUp();
        dto.setId("user");
        dto.setPw("password");
        dto.setRole("PATIENT");

        // When
        boolean result = userService.signUp(dto);

        // Then
        assertTrue(result);
    }
}
