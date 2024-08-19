package com.example.myhealthblock.opinion.adapter.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestOpinionEnroll {
    String userId;
    String content;
    Integer questionId;
}
