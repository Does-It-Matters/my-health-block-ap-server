package com.example.myhealthblock.patient.adapter.in.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultResponse {
    private String result;

    public ResultResponse(String result) {
        this.result = result;
    }
}
