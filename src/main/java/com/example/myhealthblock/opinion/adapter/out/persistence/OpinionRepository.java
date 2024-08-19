package com.example.myhealthblock.opinion.adapter.out.persistence;

import com.example.myhealthblock.question.adapter.out.persistence.question.QuestionEntity;
import com.example.myhealthblock.user.adapter.out.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository  extends JpaRepository<OpinionEntity, Integer> {
    List<OpinionEntity> findByUser(UserEntity user);
    List<OpinionEntity> findByQuestion(QuestionEntity question);
}
