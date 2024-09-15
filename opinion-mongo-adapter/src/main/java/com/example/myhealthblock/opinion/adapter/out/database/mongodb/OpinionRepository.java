package com.example.myhealthblock.opinion.adapter.out.database.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OpinionRepository extends MongoRepository<OpinionDocument, String> {
    List<OpinionDocument> findByUserId(int userId);
    List<OpinionDocument> findByQuestionId(int questionId);
}