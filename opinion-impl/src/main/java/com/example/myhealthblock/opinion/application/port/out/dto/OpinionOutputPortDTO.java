package com.example.myhealthblock.opinion.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionOutputPortDTO {
    private Integer id;
    private int userId;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;
}
