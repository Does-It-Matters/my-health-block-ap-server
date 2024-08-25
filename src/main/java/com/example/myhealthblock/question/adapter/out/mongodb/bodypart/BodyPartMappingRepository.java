package com.example.myhealthblock.question.adapter.out.mongodb.bodypart;

import com.example.myhealthblock.question.adapter.out.mybatis.bodypart.BodyPartMappingEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BodyPartMappingRepository extends MongoRepository<BodyPartMappingDocument, String> {
    void insertBodyPartMapping(BodyPartMappingEntity bodyPartMapping);

    List<BodyPartMappingEntity> findByQuestionId(@Param("questionId") Integer questionId);

    void deleteByQuestionId(@Param("questionId") Integer questionId);
}