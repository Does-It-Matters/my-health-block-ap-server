package com.example.myhealthblock.user.adapter.in.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseResult {
    private String result;

    public ResponseResult(String result) {
        this.result = result;
    }
}
