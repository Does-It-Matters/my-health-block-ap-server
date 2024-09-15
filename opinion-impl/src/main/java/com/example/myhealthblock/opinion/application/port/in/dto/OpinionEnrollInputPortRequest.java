package com.example.myhealthblock.opinion.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionEnrollInputPortRequest {
    int userId;
    String content;
    Integer questionId;
}
