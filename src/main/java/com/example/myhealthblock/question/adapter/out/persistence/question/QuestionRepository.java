package com.example.myhealthblock.question.adapter.out.persistence.question;

import com.example.myhealthblock.patient.adapter.out.persistence.PatientEntity;
import com.example.myhealthblock.question.common.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
    List<QuestionEntity> findAllByPatient(PatientEntity patient);
    List<QuestionEntity> findAllByCategory(Category category);
//    List<QuestionEntity> findByOpinionsUserUserId(String userId);
}