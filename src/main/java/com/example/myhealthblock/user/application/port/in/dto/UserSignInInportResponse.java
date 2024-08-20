package com.example.myhealthblock.user.application.port.in.dto;

import com.example.myhealthblock.user.adapter.in.web.response.SignInResponse;

import java.util.HashMap;
import java.util.Map;

public class UserSignInInportResponse {
    private Map<String, String> response;
    public UserSignInInportResponse() {
        response = new HashMap<String, String>();
        response.put("result", "fail");
        response.put("role", "");
        response.put("id", "");
    }

    public void success(String role, String id) {
        response.put("result", "success");
        response.put("role", role);
        response.put("id", id);
    }

    public SignInResponse getRequestBody() {
        SignInResponse response = new SignInResponse();
        response.setResult(this.response.get("result"));
        response.setRole(this.response.get("role"));
        response.setId(this.response.get("id"));
        return response;
    }
}
