package com.example.myhealthblock.user.adapter.out.jpa;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.user.domain.model.User;
import com.example.myhealthblock.user.application.port.out.UserOutputPort;
import lombok.RequiredArgsConstructor;

/**
 * <b> 역할: 사용자 영속성 어댑터 클래스 </b>
 * <p>
 * - 포트 및 어댑터 구조에서 출력 어댑터 역할 수행 <br>
 * - {@link UserRepository}와 연동하여 데이터베이스 작업을 수행 <br>
 * - 사용자 생성, 조회, 비밀번호 변경과 같은 사용자 관리 기능을 제공 <br>
 * </p>
 */
@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutputPort {
    private final UserRepository userRepository;

    /**
     * <b> 역할: 사용자 생성 메소드 </b>
     * <p>
     * - 새로운 사용자를 생성하여 데이터베이스에 저장 <br>
     * </p>
     *
     * @param id  생성할 사용자의 ID
     * @param pw  생성할 사용자의 비밀번호
     * @param role 생성할 사용자의 역할
     * @return 사용자가 성공적으로 생성되면 {@code true}, 그렇지 않으면 {@code false}
     */
    @Override
    public boolean create(String id, String pw, String role) {
        UserEntity user = new UserEntity();
        user.setUserId(id);
        user.setPw(pw);
        user.setRole(role);
        this.userRepository.save(user);

        return true;
    }

    /**
     * <b> 역할: 사용자 조회 </b>
     * <p>
     * - 사용자를 조회하여 {@link User} 객체로 반환 <br>
     * - {@link User} 객체 대신 DTO로 변경 예정 <br>
     * </p>
     *
     * @param id 조회할 사용자의 ID
     * @return 주어진 ID와 일치하는 {@link User} 객체, 없으면 {@code null}
     */
    @Override
    public User getUser(String id) {
        UserEntity entity = getUserEntity(id);
        if (entity == null) {
            return null;
        }

        return new User(getStringUserId(entity.getId()), entity.getUserId(), entity.getPw(), entity.getRole());
    }

    private String getStringUserId(int userId) {
        return String.valueOf(userId);
    }

    /**
     * <b> 역할: 사용자 엔티티 조회 </b>
     * <p>
     * - 데이터베이스에서 사용자 엔티티 조회 <br>
     * - 클래스 내부에 있는 다른 메소드들이 엔티티 조회할 때 사용 <br>
     * </p>
     *
     * @param id 조회할 사용자 ID
     * @return 주어진 ID와 일치하는 {@link UserEntity}, 없으면 {@code null}
     */
    private UserEntity getUserEntity(String id) {
        return this.userRepository.findByUserId(id);
    }

    /**
     * <b> 역할: 비밀번호 갱신 </b>
     * <p>
     * - 주어진 사용자 ID와 새로운 비밀번호를 이용하여 비밀번호를 업데이트 <br>
     * </p>
     *
     * @param userId 비밀번호를 변경할 사용자 ID
     * @param pw     변경할 새로운 비밀번호
     * @return 비밀번호가 성공적으로 변경되면 {@code true}, 그렇지 않으면 {@code false}
     */
    @Override
    public boolean updatePw(String userId, String pw) {
        UserEntity userEntity = getUserEntity(userId);
        if (userEntity != null) {
            userEntity.setPw(pw);
            userRepository.save(userEntity);
            return true;
        }
        return false;
    }
}
