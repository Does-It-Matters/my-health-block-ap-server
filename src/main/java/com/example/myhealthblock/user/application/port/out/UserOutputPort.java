package com.example.myhealthblock.user.application.port.out;

import com.example.myhealthblock.user.domain.dto.UserDTO;

/**
 * <b> 역할: 사용자 출력 포트 인터페이스 </b>
 * <p>
 * - 도메인 계층에서 어댑터 계층으로 데이터를 전달하는 인터페이스 <br>
 * - 사용자 생성, 조회, 비밀번호 변경 등의 기능 정의 <br>
 * </p>
 */
public interface UserOutputPort {

    /**
     * <b> 역할: 사용자 생성 메소드 </b>
     * <p>
     * - 아이디, 비밀번호, 사용자 타입으로 사용자를 생성 <br>
     * </p>
     *
     * @param id  생성할 사용자의 ID
     * @param pw  생성할 사용자의 비밀번호
     * @param role 생성할 사용자의 역할
     * @return 사용자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     */
    boolean create(String id, String pw, String role);

    /**
     * <b> 역할: 사용자 조회 메소드 </b>
     * <p>
     * - ID로 사용자 조회 <br>
     * </p>
     *
     * @param id 조회할 사용자의 ID
     * @return 주어진 ID와 일치하는 {@link UserDTO} 객체, 없으면 {@code null}
     */
    UserDTO getUser(int id);

    /**
     * <b> 역할: 비밀번호 갱신 </b>
     * <p>
     * - 새로운 비밀번호로 비밀번호를 변경 <br>
     * </p>
     *
     * @param userId 비밀번호를 변경할 사용자 ID
     * @param pw     변경할 새로운 비밀번호
     * @return 비밀번호가 성공적으로 변경되면 {@code true}, 그렇지 않으면 {@code false}
     */
    boolean updatePw(String userId, String pw);
}
