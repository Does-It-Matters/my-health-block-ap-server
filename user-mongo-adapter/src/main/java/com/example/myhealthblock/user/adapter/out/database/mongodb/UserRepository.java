package com.example.myhealthblock.user.adapter.out.database.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {

    UserDocument findByUserId(String userId);
}