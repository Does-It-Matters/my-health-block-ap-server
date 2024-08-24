package com.example.myhealthblock.question.domain.model;

import com.example.myhealthblock.question.common.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalData {
    int age;
    Gender gender;
    String disease;
    String medication;
}
