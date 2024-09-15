package com.example.myhealthblock.question.adapter.out.database.mybatis.personaldata;

import com.example.myhealthblock.question.common.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalDataEntity {

    private Integer id;
    private Integer questionId; // Use Integer for question ID
    private int age;
    private Gender gender;
    private String disease;
    private String medication;

    public PersonalDataEntity() {}

    public PersonalDataEntity(Integer questionId, int age, Gender gender, String disease, String medication) {
        this.questionId = questionId;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.medication = medication;
    }
}