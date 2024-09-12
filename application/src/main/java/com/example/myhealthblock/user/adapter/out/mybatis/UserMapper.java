package com.example.myhealthblock.user.adapter.out.mybatis;

import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;

@Mapper
public interface UserMapper {

    /**
     * <b> 역할: 사용자 생성 메소드 </b>
     * <p>
     * - 새로운 사용자를 데이터베이스에 삽입 <br>
     * </p>
     *
     * @param user 사용자 엔티티
     */
    @Insert("INSERT INTO app_user (user_id, pw, role, create_date, last_edit_date) VALUES (#{userId}, #{pw}, #{role}, #{createDate}, #{lastEditDate})")
    void insertUser(UserEntity user);

    /**
     * <b> 역할: 사용자 ID로 사용자 조회 </b>
     * <p>
     * - 주어진 사용자 ID로 사용자 엔티티 조회 <br>
     * </p>
     *
     * @param userId 조회할 사용자 ID
     * @return 주어진 ID와 일치하는 {@link UserEntity} 객체, 없으면 {@code null}
     */
    @Select("SELECT * FROM app_user WHERE user_id = #{userId}")
    UserEntity findByUserId(String userId);

    /**
     * <b> 역할: 사용자 ID로 사용자 조회 </b>
     * <p>
     * - 주어진 사용자 ID로 사용자 엔티티 조회 <br>
     * </p>
     *
     * @param id 조회할 사용자 ID
     * @return 주어진 ID와 일치하는 {@link UserEntity} 객체, 없으면 {@code null}
     */
    @Select("SELECT * FROM app_user WHERE id = #{id}")
    UserEntity findById(Integer id);

    /**
     * <b> 역할: 비밀번호 갱신 </b>
     * <p>
     * - 주어진 사용자 ID와 새로운 비밀번호를 이용하여 비밀번호를 업데이트 <br>
     * </p>
     *
     * @param userId 비밀번호를 변경할 사용자 ID
     * @param pw     변경할 새로운 비밀번호
     * @param lastEditDate 비밀번호 변경일
     */
    @Update("UPDATE app_user SET pw = #{pw}, last_edit_date = #{lastEditDate} WHERE user_id = #{userId}")
    void updatePw(@Param("userId") String userId, @Param("pw") String pw, @Param("lastEditDate") LocalDateTime lastEditDate);

    /**
     * <b> 역할: 사용자 삭제 </b>
     * <p>
     * - 주어진 사용자 ID로 사용자 엔티티를 삭제 <br>
     * </p>
     *
     * @param id 삭제할 사용자 ID
     */
    @Delete("DELETE FROM app_user WHERE id = #{id}")
    void deleteById(Integer id);

    /**
     * <b> 역할: 사용자 삭제 </b>
     * <p>
     * - 주어진 사용자 ID로 사용자 엔티티를 삭제 <br>
     * </p>
     *
     * @param userId 삭제할 사용자 ID
     */
    @Delete("DELETE FROM app_user WHERE user_id = #{userId}")
    void deleteByUserId(String userId);
}