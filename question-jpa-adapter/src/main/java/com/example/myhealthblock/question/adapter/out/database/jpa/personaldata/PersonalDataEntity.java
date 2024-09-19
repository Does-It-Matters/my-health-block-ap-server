package com.example.myhealthblock.question.adapter.out.database.jpa.personaldata;

import com.example.myhealthblock.question.adapter.out.database.jpa.question.QuestionEntity;
import com.example.myhealthblock.question.common.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>역할: 질문과 관련된 개인 데이터를 나타내는 엔티티 클래스</b>
 * <p>
 * - 데이터베이스의 'personalData' 테이블과 매핑 <br>
 * - 질문에 대한 추가적인 개인 정보(나이, 성별, 질병, 복용 약물)를 저장 <br>
 * </p>
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="personalData")
public class PersonalDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String disease;

    private String medication;

    /**
     * 모든 필드를 포함하는 생성자
     * @param question 질문 엔티티
     * @param age 나이
     * @param gender 성별
     * @param disease 질병 정보
     * @param medication 복용 중인 약물 정보
     */
    public PersonalDataEntity(QuestionEntity question, int age, Gender gender, String disease, String medication) {
        this.question = question;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.medication = medication;
    }
}
