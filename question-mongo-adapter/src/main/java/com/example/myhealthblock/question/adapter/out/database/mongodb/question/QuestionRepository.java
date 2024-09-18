package com.example.myhealthblock.question.adapter.out.database.mongodb.question;

import com.example.myhealthblock.question.common.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<QuestionDocument, String> {
    List<QuestionDocument> findAllByUserId(Integer userId);
    List<QuestionDocument> findAllByCategory(Category category);
}