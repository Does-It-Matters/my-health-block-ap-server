package com.example.myhealthblock.user.adapter.out.persistence;

import com.example.myhealthblock.user.adapter.out.database.jpa.UserEntity;
import com.example.myhealthblock.user.adapter.out.database.jpa.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <b> 역할: {@link UserEntity} 클래스의 단위 테스트 클래스 </b>
 * <p>
 * - CRUD 정상 작동 검증 <br>
 * </p>
 */
@DataJpaTest
public class UserEntityTest {

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    /**
     * <b> 역할: 테스트 전 {@link UserEntity} 초기화 메소드 </b>
     * <p>
     * - UserEntity 기본 정보 설정 <br>
     * </p>
     */
    @BeforeEach
    public void setUp() {
        userEntity = new UserEntity();
        userEntity.setUserId("user123");
        userEntity.setPw("password123");
        userEntity.setRole("PATIENT");
    }

    /**
     * <b> 역할: {@link UserEntity} 저장 테스트 메소드 </b>
     * <p>
     * - 저장 후 자동 생성된 ID와 설정한 필드 값 검증 <br>
     * </p>
     */
    @Test
    @DisplayName("UserEntity 저장 테스트")
    public void testSaveUserEntity() {
        UserEntity savedUser = userRepository.save(userEntity);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getUserId()).isEqualTo("user123");
        assertThat(savedUser.getPw()).isEqualTo("password123");
        assertThat(savedUser.getRole()).isEqualTo("PATIENT");
    }

    /**
     * <b> 역할: {@link UserEntity} 조회 테스트 메소드 </b>
     * <p>
     * - userId로 조회 <br>
     * </p>
     */
    @Test
    @DisplayName("UserEntity 조회 테스트")
    public void testFindByUserId() {
        userRepository.save(userEntity);

        UserEntity foundUser = userRepository.findByUserId("user123");

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUserId()).isEqualTo("user123");
        assertThat(foundUser.getPw()).isEqualTo("password123");
        assertThat(foundUser.getRole()).isEqualTo("PATIENT");
    }

    /**
     * <b> 역할: {@link UserEntity} 갱신 테스트 메소드 </b>
     * <p>
     * - 비밀번호 갱신 <br>
     * - 갱신 일자가 생성 일자 이후인지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("UserEntity 갱신 테스트")
    public void testUpdateUserEntity() {
        UserEntity savedUser = userRepository.save(userEntity);

        savedUser.setPw("newpassword123");
        UserEntity updatedUser = userRepository.save(savedUser);

        assertThat(updatedUser.getPw()).isEqualTo("newpassword123");
        assertThat(updatedUser.getLastEditDate()).isAfter(savedUser.getCreateDate());
    }

    /**
     * <b> 역할: {@link UserEntity} 삭제 테스트 메소드 </b>
     * <p>
     * - 객체 삭제
     * - 데이터베이스에서 해당 객체가 삭제되었는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("UserEntity 삭제 테스트")
    public void testDeleteUserEntity() {
        UserEntity savedUser = userRepository.save(userEntity);

        userRepository.deleteById(savedUser.getId());

        UserEntity foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertThat(foundUser).isNull();
    }
}