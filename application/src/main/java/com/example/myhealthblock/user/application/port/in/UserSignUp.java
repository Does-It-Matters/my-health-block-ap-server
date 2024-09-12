package com.example.myhealthblock.user.application.port.in;

import com.example.myhealthblock.user.application.port.in.dto.UserSignUpInputPortRequest;

public interface UserSignUp {

    /**
     * <b> 역할: 사용자 생성 요청 메소드 </b>
     * <p>
     *
     * @param dto  사용자 생성에 필요한 정보를 가진 dto
     * @return 사용자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     * </p>
     */
    boolean signUp(UserSignUpInputPortRequest dto);
}
