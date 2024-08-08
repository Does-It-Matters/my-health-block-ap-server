package com.example.myhealthblock.user.dto;

import com.example.myhealthblock.user.adapter.in.response.ResponseSignIn;

import java.util.HashMap;
import java.util.Map;

public class ResultSignIn {
    private Map<String, String> response;
    public ResultSignIn () {
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

    public ResponseSignIn getRequestBody() {
        ResponseSignIn response = new ResponseSignIn();
        response.setResult(this.response.get("result"));
        response.setRole(this.response.get("role"));
        response.setId(this.response.get("id"));
        return response;
    }
}
