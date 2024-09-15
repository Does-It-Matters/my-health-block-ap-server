package com.example.myhealthblock.user.adapter.out.database.jpa;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * <b> 역할: 사용자 엔티티 클래스 </b>
 * <p>
 * - 데이터베이스의 'app_user' 테이블과 매핑 <br>
 * - JPA와 Hibernate를 통해 데이터베이스와 상호작용 <br>
 * </p>
 */
@Getter
@Setter
@Entity(name = "AppUser")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String userId;

    @Column(length = 200)
    private String pw;

    @Column(length = 200)
    private String role;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastEditDate;
}
