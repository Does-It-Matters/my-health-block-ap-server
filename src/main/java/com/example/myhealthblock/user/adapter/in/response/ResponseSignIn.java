package com.example.myhealthblock.user.adapter.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSignIn {
    private String accessToken;
    private String refreshToken;
    private String role;

    public ResponseSignIn(String errorMessage) {
        this.accessToken = null;
        this.refreshToken = null;
        this.role = errorMessage;
    }

}
