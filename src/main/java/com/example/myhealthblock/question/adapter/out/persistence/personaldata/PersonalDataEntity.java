//package com.example.myhealthblock.question.adapter.out.persistence.personaldata;
//
//import com.example.myhealthblock.question.common.Gender;
//import com.example.myhealthblock.question.adapter.out.persistence.question.QuestionEntity;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor
//@Table(name="personalData")
//public class PersonalDataEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "question_id")
//    private QuestionEntity question;
//
//    private int age;
//
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    private String disease;
//
//    private String medication;
//}
