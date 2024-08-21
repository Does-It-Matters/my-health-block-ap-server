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

    /**
     * <b> 역할: 로그인 메소드 </b>
     * <p>
     * - 비밀번호가 동일한지 확인 <br>
     *
     * @param pw 사용자가 로그인 요청 시 입력한 비밀번호
     * @return 비밀번호와 동일하면 {@code true}, 동일하지 않으면 {@code false} <br>
     * </p>
     */
    @Override
    public boolean signIn(String pw) {
        return this.pw.equals(pw);
    }

    /**
     * <b> 역할: 비밀번호 변경 메소드 </b>
     * <p>
     * - 기존 비밀번호와 동일하면 새로운 비밀번호로 변경 <br>
     * - 입력 유효성 검사 로직 필요 <br>
     *
     * @param oldPw 사용자가 비밀번호 변경을 위해 입력한 기존 비밀번호
     * @param newPw 사용자가 비밀번호 변경을 위해 입력한 변경 비밀번호
     * @return 변경되면 {@code true}, 변경되지 않으면 {@code false} <br>
     * </p>
     */
    @Override
    public boolean changePw(String oldPw, String newPw) {
        if (pw.equals(oldPw)) {
            pw = newPw;
            return true;
        }
        return false;
    }
}
