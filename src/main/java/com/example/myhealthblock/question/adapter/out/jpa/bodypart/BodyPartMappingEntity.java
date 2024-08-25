package com.example.myhealthblock.question.adapter.out.jpa.bodypart;

import com.example.myhealthblock.question.adapter.out.jpa.question.QuestionEntity;
import com.example.myhealthblock.question.common.BodyPart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public BodyPartMappingEntity(QuestionEntity question, BodyPart bodyPart) {
        this.question = question;
        this.bodyPart = bodyPart;
    }
}
