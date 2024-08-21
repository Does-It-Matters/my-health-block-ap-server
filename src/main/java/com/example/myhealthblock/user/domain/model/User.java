package com.example.myhealthblock.user.domain.model;

import com.example.myhealthblock.user.domain.model.auth.SignInable;
import com.example.myhealthblock.user.domain.model.security.PasswordManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: User 도메인 모델 클래스 </b>
 * <p>
 * - 사용자 로직 처리 <br>
 * </p>
 */
@AllArgsConstructor
@Getter
@Setter
public class User implements SignInable, PasswordManager {
    Integer id;
    String uid;
    String pw;
    String role;

    @Override
    public boolean signIn(String pw) {
        return this.pw.equals(pw);
    }

    @Override
    public boolean changePw(String oldPw, String newPw) {
        if (pw.equals(oldPw)) {
            pw = newPw;
            return true;
        }
        return false;
    }
}
