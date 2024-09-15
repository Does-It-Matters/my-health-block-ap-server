package com.example.myhealthblock.question.adapter.out.database.mybatis.bodypart;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BodyPartMappingMapper {

    void insertBodyPartMapping(BodyPartMappingEntity bodyPartMapping);

    List<BodyPartMappingEntity> findByQuestionId(@Param("questionId") Integer questionId);

    void deleteByQuestionId(@Param("questionId") Integer questionId);
}