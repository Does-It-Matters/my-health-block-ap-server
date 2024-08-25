package com.example.myhealthblock.question.adapter.out.mybatis.bodypart;

import com.example.myhealthblock.question.common.BodyPart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyPartMappingEntity {

    private Integer id;
    private Integer questionId; // Use Integer for question ID
    private BodyPart bodyPart;

    public BodyPartMappingEntity() {}

    public BodyPartMappingEntity(Integer questionId, BodyPart bodyPart) {
        this.questionId = questionId;
        this.bodyPart = bodyPart;
    }
}