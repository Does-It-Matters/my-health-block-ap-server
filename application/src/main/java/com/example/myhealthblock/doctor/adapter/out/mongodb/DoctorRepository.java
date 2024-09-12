package com.example.myhealthblock.doctor.adapter.out.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<DoctorDocument, String> {
    DoctorDocument findByUserId(String userId);
}