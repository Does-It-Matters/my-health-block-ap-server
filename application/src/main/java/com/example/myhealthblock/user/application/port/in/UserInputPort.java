package com.example.myhealthblock.user.application.port.in;

import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserSignUpInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserUpdatePwInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortResponse;

/**
 * <b> 역할: 사용자 관리 입력 포트 인터페이스 </b>
 * <p>
 * - 입력 어댑터 계층에서 도메인 계층으로 데이터를 전달하는 인터페이스 <br>
 * - 사용자 생성(회원가입), 로그인, 비밀번호 변경 등의 기능 정의 <br>
 * </p>
 */
public interface UserInputPort extends UserSignUp {

    /**
     * <b> 역할: 사용자 로그인 요청 메소드 </b>
     * <p>
     *
     * @param dto  로그인에 필요한 정보를 가진 dto
     * @return 사용자가 로그인 결롸에 따른 dto
     * </p>
     */
    UserSignInInputPortResponse signIn(UserSignInInputPortRequest dto);

//    User signInWithJWT(UserSignInRequest dto) throws Exception;

    /**
     * <b> 역할: 비밀번호 변경 요청 메소드 </b>
     * <p>
     *
     * @param dto  비밀번호 변경에 필요한 정보를 가진 dto
     * @return 성공하면 {@code "success"}, 실패하면 {@code "fail"}
     * </p>
     */
    String changePw(String userId, UserUpdatePwInputPortRequest dto);
}
