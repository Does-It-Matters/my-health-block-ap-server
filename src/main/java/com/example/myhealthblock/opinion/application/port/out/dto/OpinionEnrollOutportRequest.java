package com.example.myhealthblock.opinion.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionEnrollOutportRequest {
    int userId;
    String content;
    Integer questionId;
}
