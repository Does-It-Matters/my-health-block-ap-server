package com.example.myhealthblock.question.adapter.out.jpa.bodypart;

import com.example.myhealthblock.question.adapter.out.jpa.question.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BodyMappingRepository extends JpaRepository<BodyPartMappingEntity, Integer> {
    @Query("SELECT bpme FROM BodyPartMappingEntity bpme WHERE bpme.question = :question")
    List<BodyPartMappingEntity> findByQuestion(@Param("question") QuestionEntity question);
}
