package com.example.myhealthblock.user.adapter.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSignInWithJwt {
    private String refreshToken;
    private String role;

    public ResponseSignInWithJwt(String errorMessage) {
        this.refreshToken = null;
        this.role = errorMessage;
    }

}
