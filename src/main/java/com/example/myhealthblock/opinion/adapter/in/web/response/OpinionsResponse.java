package com.example.myhealthblock.opinion.adapter.in.web.response;

import com.example.myhealthblock.opinion.application.port.in.dto.OpinionInportDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionsResponse {
    private OpinionInportDTO[] opinions;
}
