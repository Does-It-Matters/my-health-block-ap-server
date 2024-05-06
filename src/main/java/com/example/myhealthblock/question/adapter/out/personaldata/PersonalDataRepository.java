package com.example.myhealthblock.question.adapter.out.personaldata;

import com.example.myhealthblock.question.adapter.out.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository  extends JpaRepository<PersonalDataEntity, Integer> {
    PersonalDataEntity findByQuestion(QuestionEntity question);
}
