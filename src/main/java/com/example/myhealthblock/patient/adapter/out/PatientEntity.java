package com.example.myhealthblock.patient.adapter.out;

import com.example.myhealthblock.question.adapter.out.QuestionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Patient")
public class PatientEntity {
    public PatientEntity(String userId){
        this();
        this.userId = userId;
    }

    public PatientEntity() {
        this.createDate = LocalDateTime.now();
        this.lastEditDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userId;

    @Column
    private String urgentData;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionEntity> questions = new ArrayList<>();

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime lastEditDate;

    public void addQuestion(QuestionEntity question) {
        questions.add(question);
        question.setPatient(this);
    }

}
