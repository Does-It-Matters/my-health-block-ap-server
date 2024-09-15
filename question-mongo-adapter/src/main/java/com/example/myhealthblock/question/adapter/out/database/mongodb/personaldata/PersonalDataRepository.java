package com.example.myhealthblock.question.adapter.out.database.mongodb.personaldata;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalDataRepository extends MongoRepository<PersonalDataDocument, String> {
    PersonalDataDocument findByQuestionId(String questionId);
}