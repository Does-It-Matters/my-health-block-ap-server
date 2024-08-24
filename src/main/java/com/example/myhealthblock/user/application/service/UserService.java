package com.example.myhealthblock.user.application.service;

import com.example.myhealthblock.user.application.port.in.UserInputPort;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortResponse;
import com.example.myhealthblock.user.application.port.in.dto.UserSignUpInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserUpdatePwInputPortRequest;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import com.example.myhealthblock.user.domain.model.User;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 사용자 관리 서비스 클래스 </b>
 * <p>
 * - 입력 포트와 출력 포트, 도메인 모델과 상호작용하여 비즈니스 로직을 처리 <br>
 * - 사용자 생성(회원가입), 로그인, 비밀번호 변경 등의 기능 처리 <br>
 * </p>
 */
@RequiredArgsConstructor
@Service
public class UserService implements UserInputPort {
    private final UserOutputPort outport;

    /**
     * <b> 역할: 사용자 생성 요청 메소드 </b>
     * <p>
     * - 출력 포트로 부터 이미 회원가입된 아이디인지 확인 <br>
     * - 이미 회원가입된 아이디가 아니라면 생성 처리 <br>
     * </p>
     *
     * @param dto  사용자 생성에 필요한 정보를 가진 dto
     * @return 사용자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     */
    @Override
    public boolean signUp(UserSignUpInputPortRequest dto) {
        User user = outport.getUser(dto.getId());
        if (user == null)
            return outport.create(dto.getId(), dto.getPw(), dto.getRole());
        return false;
    }

    /**
     * <b> 역할: 사용자 로그인 요청 메소드 </b>
     * <p>
     * - 출력 포트로 부터 입력된 아이디에 대한 정보 조회 <br>
     * - 조회된 정보가 없거나 로그인 실패 시 예외를 던짐 <br>
     * - 로그인 성공 시 응답 반환 <br>
     * </p>
     *
     * @param dto  로그인에 필요한 정보를 가진 dto
     * @return 사용자가 로그인 결롸에 따른 dto
     */
    @Override
    public UserSignInInputPortResponse signIn(UserSignInInputPortRequest dto) {
        User user = outport.getUser(dto.getId());

        if (user!=null && user.signIn(dto.getPw()))
            return new UserSignInInputPortResponse(user.getRole(), user.getUid());

        throw new RuntimeException();
    }

//    public User signInWithJWT(UserSignInInputPortRequest dto) throws Exception {
//        User user = outport.getUser(dto.getId());
//
//        if (user!=null && user.signIn(dto.getPw()))
//            return user;
//        throw new Exception("Invalid credentials");
//    }

    /**
     * <b> 역할: 비밀번호 변경 요청 메소드 </b>
     * <p>
     * - 출력 포트로 부터 입력된 아이디에 대한 정보 조회 <br>
     * - 비밀번호 변경 작업 수행 <br>
     * - 실패 시 예외를 던짐 <br>
     * </p>
     *
     * @param userId  비밀번호 변경할 아이디
     * @param dto  비밀번호 변경에 필요한 정보를 가진 dto
     * @return 성공하면 {@code "success"}, 실패하면 {@code "fail"}
     */
    @Override
    public String changePw(String userId, UserUpdatePwInputPortRequest dto) {
        User user = outport.getUser(userId);
        if(user.changePw(dto.getOldPw(), dto.getNewPw())) {
            outport.updatePw(user.getUid(), user.getPw());
            return "success";
        }

        throw new RuntimeException();
    }
}
