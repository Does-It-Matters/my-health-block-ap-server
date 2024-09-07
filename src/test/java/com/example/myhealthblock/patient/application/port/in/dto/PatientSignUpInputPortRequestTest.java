package com.example.myhealthblock.patient.application.port.in.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <b> 역할: {@link PatientSignUpInputPortRequest} 클래스 단위 테스트 클래스 </b>
 */
class PatientSignUpInputPortRequestTest {

	/**
	 * <b> 역할: {@link PatientSignUpInputPortRequest} 기본 생성자 테스트 메소드 </b>
	 * <p>
	 * - 기본 생성자 사용 시 필드들이 초기화되지 않았는지 확인 <br>
	 * </p>
	 */
	@Test
	@DisplayName("기본 생성자 테스트")
	public void testNoArgsConstructor() {
		PatientSignUpInputPortRequest dto = new PatientSignUpInputPortRequest();
		assertNull(dto.getId(), "ID 필드는 null이어야 합니다.");
		assertNull(dto.getPw(), "PW 필드는 null이어야 합니다.");
		assertNull(dto.getRole(), "Role 필드는 null이어야 합니다.");
	}

	/**
	 * <b> 역할: {@link PatientSignUpInputPortRequest} 필드의 Getter 및 Setter 테스트 메소드 </b>
	 * <p>
	 * - Setter를 사용하여 필드 값을 설정한 후, Getter를 통해 올바르게 반환되는지 확인 <br>
	 * </p>
	 */
	@Test
	@DisplayName("Getter 및 Setter 테스트")
	public void testSettersAndGetters() {
		PatientSignUpInputPortRequest dto = new PatientSignUpInputPortRequest();
		dto.setId("patient123");
		dto.setPw("password123");
		dto.setRole("PATIENT");

		assertEquals("patient123", dto.getId(), "Getter를 통해 얻은 ID 필드 값이 설정한 값과 일치해야 합니다.");
		assertEquals("password123", dto.getPw(), "Getter를 통해 얻은 PW 필드 값이 설정한 값과 일치해야 합니다.");
		assertEquals("PATIENT", dto.getRole(), "Getter를 통해 얻은 Role 필드 값이 설정한 값과 일치해야 합니다.");
	}
}