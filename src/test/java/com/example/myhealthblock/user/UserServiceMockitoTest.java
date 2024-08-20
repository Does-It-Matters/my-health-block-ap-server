package com.example.myhealthblock.user;

import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutport;
import com.example.myhealthblock.user.application.service.UserService;
import com.example.myhealthblock.user.adapter.in.web.request.UserSignUpRequest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceMockitoTest {

    @Test
    void testSignUp_Success() {
        // Given
        UserOutport outport = mock(UserOutport.class);
        UserService userService = new UserService(outport);
        UserSignUpRequest dto = new UserSignUpRequest();
        dto.setId("user");
        dto.setPw("password");
        dto.setRole("PATIENT");

        when(outport.getUser(dto.getId())).thenReturn(null);
        when(outport.create(dto.getId(), dto.getPw(), dto.getRole())).thenReturn(true);

        // When
        boolean result = userService.signUp(dto);

        // Then
        assertTrue(result);
        verify(outport).create(dto.getId(), dto.getPw(), dto.getRole());
    }

    @Test
    void testSignUp_Fail_UserAlreadyExists() {
        // Given
        UserOutport outport = mock(UserOutport.class);
        UserService userService = new UserService(outport);
        UserSignUpRequest dto = new UserSignUpRequest();
        dto.setId("user");
        dto.setPw("password");
        dto.setRole("PATIENT");

        when(outport.getUser(dto.getId())).thenReturn(new User(null, "user", "password", "PATIENT"));

        // When
        boolean result = userService.signUp(dto);

        // Then
        assertFalse(result);
        verify(outport, never()).create(dto.getId(), dto.getPw(), dto.getRole());
    }
}
