package com.example.myhealthblock.question.adapter.out.database.mongodb.bodypart;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BodyPartMappingRepository extends MongoRepository<BodyPartMappingDocument, String> {
    List<BodyPartMappingDocument> findByQuestionId(String questionId);
}