package com.example.myhealthblock.question.adapter.out.database.mybatis.personaldata;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PersonalDataMapper {

    void insertPersonalData(PersonalDataEntity personalData);

    PersonalDataEntity findByQuestionId(@Param("questionId") Integer questionId);

    void deletePersonalData(@Param("id") Integer id);
}