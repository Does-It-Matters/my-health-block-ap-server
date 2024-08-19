package com.example.myhealthblock.user.adapter.in.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInWithJwtResponse {
    private String refreshToken;
    private String role;

    public SignInWithJwtResponse(String errorMessage) {
        this.refreshToken = null;
        this.role = errorMessage;
    }

}
