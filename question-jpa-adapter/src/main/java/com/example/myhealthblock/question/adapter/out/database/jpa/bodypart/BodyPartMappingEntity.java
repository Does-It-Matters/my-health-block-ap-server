package com.example.myhealthblock.question.adapter.out.database.jpa.bodypart;

import com.example.myhealthblock.question.adapter.out.database.jpa.question.QuestionEntity;
import com.example.myhealthblock.question.common.BodyPart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>역할: 질문과 신체 부위 간의 매핑을 나타내는 엔티티 클래스</b>
 * <p>
 * - 데이터베이스의 'bodypartMapping' 테이블과 매핑 <br>
 * - 질문과 관련된 신체 부위를 연결하는 중간 테이블 역할 수행 <br>
 * </p>
 */
@Getter
@Setter
@Entity
@Table(name = "bodypartMapping")
@NoArgsConstructor
public class BodyPartMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;

    /**
     * 질문과 신체 부위를 매핑하는 생성자
     * @param question 연관된 질문 엔티티
     * @param bodyPart 매핑할 신체 부위
     */
    public BodyPartMappingEntity(QuestionEntity question, BodyPart bodyPart) {
        this.question = question;
        this.bodyPart = bodyPart;
    }
}
