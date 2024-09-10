package com.example.myhealthblock.user.domain.dto;

import com.example.myhealthblock.user.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
	String id;
	String uid;
	String pw;
	String role;

	/**
	 * <b> 역할: UserDTO를 User 엔티티로 변환하는 메소드 </b>
	 * <p>
	 * - UserDTO 객체를 User 엔티티로 변환 <br>
	 * </p>
	 * @return User 엔티티 객체
	 */
	public User toEntity() {
		return new User(
			Integer.parseInt(this.id),
			this.uid,
			this.pw,
			this.role
		);
	}
}
