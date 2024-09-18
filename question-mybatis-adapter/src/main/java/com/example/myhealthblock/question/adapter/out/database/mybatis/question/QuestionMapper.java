package com.example.myhealthblock.question.adapter.out.database.mybatis.question;

import com.example.myhealthblock.question.common.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    void insertQuestion(QuestionEntity question);

    List<QuestionEntity> findAllByUserId(@Param("userId") Integer userId);

    List<QuestionEntity> findAllByCategory(@Param("category") Category category);

    List<QuestionEntity> findAll();

    QuestionEntity findById(@Param("id") Integer id);

    void updateQuestion(QuestionEntity question);

    void deleteQuestion(@Param("id") Integer id);
}