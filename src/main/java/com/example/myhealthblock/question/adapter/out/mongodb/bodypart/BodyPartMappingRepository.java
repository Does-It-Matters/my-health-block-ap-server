package com.example.myhealthblock.question.adapter.out.mongodb.bodypart;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BodyPartMappingRepository extends MongoRepository<BodyPartMappingDocument, String> {
    List<BodyPartMappingDocument> findByQuestionId(String questionId);
}