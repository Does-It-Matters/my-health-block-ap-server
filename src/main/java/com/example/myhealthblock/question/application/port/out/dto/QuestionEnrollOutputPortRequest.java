package com.example.myhealthblock.question.application.port.out.dto;

import com.example.myhealthblock.question.common.BodyPart;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEnrollOutputPortRequest {
    int userId;
    List<BodyPart> bodyParts;
    Category category;
    String title;
    String symptom;
    String content;
    PersonalDataDTO personalData;
}
