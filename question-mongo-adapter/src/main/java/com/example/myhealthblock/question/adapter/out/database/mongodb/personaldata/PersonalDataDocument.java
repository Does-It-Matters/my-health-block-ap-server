package com.example.myhealthblock.question.adapter.out.database.mongodb.personaldata;

import com.example.myhealthblock.question.common.Gender;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "personalData")
public class PersonalDataDocument {

    @Id
    private String id;
    private String questionId; // Store question ID as a string
    private int age;
    private Gender gender;
    private String disease;
    private String medication;

    public PersonalDataDocument() {}

    public PersonalDataDocument(String questionId, int age, Gender gender, String disease, String medication) {
        this.questionId = questionId;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.medication = medication;
    }
}