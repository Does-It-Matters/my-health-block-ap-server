package com.example.myhealthblock.opinion.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionOutportDTO {
    private Integer id;
    private int userId;
    private String content;
    private Date createDate;
    private Date lastModifiedDate;
}
