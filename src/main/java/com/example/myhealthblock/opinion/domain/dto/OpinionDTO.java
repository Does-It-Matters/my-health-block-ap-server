package com.example.myhealthblock.opinion.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionDTO {
    private Integer id;
    private String userId;
    private String content;
    private Date createDate;
    private Date lastModifiedDate;
}
