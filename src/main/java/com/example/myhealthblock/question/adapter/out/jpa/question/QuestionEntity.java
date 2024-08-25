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

@Getter
@Setter
@Entity(name = "Question")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class QuestionEntity {
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
