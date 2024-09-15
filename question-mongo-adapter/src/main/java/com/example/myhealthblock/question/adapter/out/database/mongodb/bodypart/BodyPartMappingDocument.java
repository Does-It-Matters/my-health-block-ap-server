package com.example.myhealthblock.question.adapter.out.database.mongodb.bodypart;

import com.example.myhealthblock.question.common.BodyPart;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "bodypartMapping")
public class BodyPartMappingDocument {

    @Id
    private String id;
    private String questionId; // Store question ID as a string
    private BodyPart bodyPart;

    public BodyPartMappingDocument() {}

    public BodyPartMappingDocument(String questionId, BodyPart bodyPart) {
        this.questionId = questionId;
        this.bodyPart = bodyPart;
    }
}