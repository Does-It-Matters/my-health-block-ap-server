package com.example.myhealthblock.opinion.adapter.out.database.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OpinionMapper {

    void insertOpinion(OpinionEntity opinion);

    List<OpinionEntity> selectOpinionsByUserId(@Param("userId") int userId);

    List<OpinionEntity> selectOpinionsByQuestionId(@Param("questionId") int questionId);

    void deleteOpinion(@Param("id") int id);
}
