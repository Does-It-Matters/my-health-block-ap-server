package com.example.myhealthblock.question.adapter.out.persistence.question;

import com.example.myhealthblock.question.common.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
    List<QuestionEntity> findAllByUserId(int userId);
    List<QuestionEntity> findAllByCategory(Category category);
}
