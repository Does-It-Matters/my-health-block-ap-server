package com.example.myhealthblock.user.application.port.in.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> 역할: {@link UserSignUpInputPortRequestDTO} 클래스 단위 테스트 클래스 </b>
 */
public class UserSignUpInputPortRequestTest {

    /**
     * <b> 역할: {@link UserSignUpInputPortRequestDTO} 기본 생성자 테스트 메소드 </b>
     * <p>
     * - 기본 생성자 사용 시 필드들이 초기화되지 않았는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("기본 생성자 테스트")
    public void testNoArgsConstructor() {
        UserSignUpInputPortRequest dto = new UserSignUpInputPortRequestDTO();
        assertNull(dto.getId(), "ID 필드는 null이어야 합니다.");
        assertNull(dto.getPw(), "PW 필드는 null이어야 합니다.");
        assertNull(dto.getRole(), "Role 필드는 null이어야 합니다.");
    }

    /**
     * <b> 역할: {@link UserSignUpInputPortRequestDTO} 필드의 Getter 및 Setter 테스트 메소드 </b>
     * <p>
     * - Setter를 사용하여 필드 값을 설정한 후, Getter를 통해 올바르게 반환되는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("Getter 및 Setter 테스트")
    public void testSettersAndGetters() {
        UserSignUpInputPortRequest dto = new UserSignUpInputPortRequestDTO();
        dto.setId("user123");
        dto.setPw("password123");
        dto.setRole("DOCTOR");

        assertEquals("user123", dto.getId(), "Getter를 통해 얻은 ID 필드 값이 설정한 값과 일치해야 합니다.");
        assertEquals("password123", dto.getPw(), "Getter를 통해 얻은 PW 필드 값이 설정한 값과 일치해야 합니다.");
        assertEquals("DOCTOR", dto.getRole(), "Getter를 통해 얻은 Role 필드 값이 설정한 값과 일치해야 합니다.");
    }
}