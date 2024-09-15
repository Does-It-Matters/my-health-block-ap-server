package com.example.myhealthblock.question.adapter.out.database.jpa.personaldata;

import com.example.myhealthblock.question.adapter.out.database.jpa.question.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>역할: 개인 데이터 레포지토리 인터페이스</b>
 * <p>
 * - {@link JpaRepository} 상속하여 기본적인 CRUD 제공 <br>
 * - {@link PersonalDataEntity} 엔티티 관리 <br>
 * </p>
 */
public interface PersonalDataRepository  extends JpaRepository<PersonalDataEntity, Integer> {

    /**
     * <b>역할: 특정 질문에 해당하는 개인 데이터 조회</b>
     * <p>
     *
     * @param question 조회할 {@link QuestionEntity} 객체
     * @return 주어진 질문의 {@link PersonalDataEntity} 객체, 없으면 null 반환
     */
    PersonalDataEntity findByQuestion(QuestionEntity question);
}
