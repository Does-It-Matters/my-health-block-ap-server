package com.example.myhealthblock.opinion.adapter.in.web.response;

import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInputPortDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollOpinionResponse {
    private OpinionInputPortDTO opinionInportDTO;
}
