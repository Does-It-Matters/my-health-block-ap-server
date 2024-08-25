package com.example.myhealthblock.opinion.domain.model;

import com.example.myhealthblock.question.domain.model.Question;
import com.example.myhealthblock.user.domain.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Opinion {
    int id;
    User user;
    String content;
    Question question;
}
