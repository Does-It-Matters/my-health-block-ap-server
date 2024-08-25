package com.example.myhealthblock.opinion.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository  extends JpaRepository<OpinionEntity, Integer> {
    List<OpinionEntity> findByUserId(int userId);
    List<OpinionEntity> findByQuestionId(int questionId);
}
