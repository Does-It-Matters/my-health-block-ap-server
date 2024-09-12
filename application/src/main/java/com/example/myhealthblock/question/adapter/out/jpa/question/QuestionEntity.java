package com.example.myhealthblock.question.adapter.out.jpa.question;

import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.adapter.out.jpa.bodypart.BodyPartMappingEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>역할: 사용자의 질문 정보를 나타내는 엔티티 클래스</b>
 * <p>
 * - 데이터베이스의 'Question' 테이블과 매핑 <br>
 * - 사용자 질문의 상세 정보(제목, 카테고리, 증상, 내용 등)를 저장 <br>
 * </p>
 */
@Getter
@Setter
@Entity(name = "Question")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class QuestionEntity {

    /**
     * 모든 필수 필드를 포함하는 생성자
     *
     * @param userId 사용자 ID
     * @param title 질문 제목
     * @param category 질문 카테고리
     * @param symptom 증상 설명
     * @param content 질문 내용
     */
    public QuestionEntity(int userId, String title, Category category, String symptom, String content){
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.symptom = symptom;
        this.content = content;
        createDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String symptom;

    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BodyPartMappingEntity> bodyPartMappings = new ArrayList<>();
}
