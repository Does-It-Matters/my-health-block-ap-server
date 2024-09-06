package com.example.myhealthblock.question.domain.model;

import com.example.myhealthblock.question.common.Gender;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: PersonalData 도메인 모델 클래스 </b>
 */
@Getter
@Setter
public class PersonalData {
    int age;
    Gender gender;
    String disease;
    String medication;
}
