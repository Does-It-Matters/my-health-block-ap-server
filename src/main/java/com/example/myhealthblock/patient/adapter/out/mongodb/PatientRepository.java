package com.example.myhealthblock.patient.adapter.out.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<PatientDocument, String> {
}