package com.example.myhealthblock.user.adapter.out.persistence;

import com.example.myhealthblock.opinion.adapter.out.persistence.OpinionEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "AppUser")
@NoArgsConstructor
public class UserEntity {

    public UserEntity(String userId, String pw, String role) {
        this.userId = userId;
        this.pw = pw;
        this.role = role;
        createDate = LocalDateTime.now();
        lastEditDate = LocalDateTime.now();
    }

    public UserEntity(String userId, String pw, String role, LocalDateTime createDate, LocalDateTime lastEditDate) {
        this(userId, pw, role);
        this.createDate = createDate;
        this.lastEditDate = lastEditDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String userId;

    @Column(length = 200)
    private String pw;

    @Column(length = 200)
    private String role;

    private LocalDateTime createDate;

    private LocalDateTime lastEditDate;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<OpinionEntity> opinions;

    public void setPw(String pw) {
        this.pw = pw;
        this.lastEditDate = LocalDateTime.now();
    }
}
