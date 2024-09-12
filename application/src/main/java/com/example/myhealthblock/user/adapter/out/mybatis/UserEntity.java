package com.example.myhealthblock.user.adapter.out.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <b> 역할: 사용자 엔티티 클래스 </b>
 * <p>
 * - 데이터베이스의 'app_user' 테이블과 매핑 <br>
 * - MyBatis 매퍼와의 상호작용을 위해 사용됨 <br>
 * </p>
 */
@Getter
@Setter
public class UserEntity {

    private Integer id;
    private String userId;
    private String pw;
    private String role;
    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;
}