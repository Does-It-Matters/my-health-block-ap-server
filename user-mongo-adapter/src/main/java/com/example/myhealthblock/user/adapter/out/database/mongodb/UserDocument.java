package com.example.myhealthblock.user.adapter.out.database.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "users")
public class UserDocument {

    @Id
    private String id; // MongoDB의 기본 ID 타입은 String입니다.
    private String userId;
    private String pw;
    private String role;
    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;
}