package com.example.myhealthblock.user.domain.dto;

import com.example.myhealthblock.user.adapter.out.persistence.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEntityDTO {
    UserEntity entity;
}
