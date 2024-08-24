package com.example.myhealthblock.user.application.port.in.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> 역할: {@link UserSignInInputPortRequest} 클래스 단위 테스트 클래스 </b>
 */
public class UserSignInInputPortRequestTest {

    /**
     * <b> 역할: {@link UserSignInInputPortRequest} 기본 생성자 테스트 메소드 </b>
     * <p>
     * - 기본 생성자 사용 시 필드들이 초기화되지 않았는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("기본 생성자 테스트")
    public void testNoArgsConstructor() {
        UserSignInInputPortRequest dto = new UserSignInInputPortRequest();
        assertNull(dto.getId(), "ID 필드는 null이어야 합니다.");
        assertNull(dto.getPw(), "PW 필드는 null이어야 합니다.");
    }

    /**
     * <b> 역할: {@link UserSignInInputPortRequest} 모든 필드를 초기화하는 생성자 테스트 메소드 </b>
     * <p>
     * - 모든 필드를 초기화하는 생성자 사용 시 필드 값들이 올바르게 설정되는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("모든 필드를 초기화하는 생성자 테스트")
    public void testAllArgsConstructor() {
        UserSignInInputPortRequest dto = new UserSignInInputPortRequest("user123", "password123");
        assertEquals("user123", dto.getId(), "ID 필드가 초기화된 값과 일치해야 합니다.");
        assertEquals("password123", dto.getPw(), "PW 필드가 초기화된 값과 일치해야 합니다.");
    }

    /**
     * <b> 역할: {@link UserSignInInputPortRequest} 필드의 Getter 및 Setter 테스트 메소드 </b>
     * <p>
     * - Setter를 사용하여 필드 값을 설정한 후, Getter를 통해 올바르게 반환되는지 확인 <br>
     * </p>
     */
    @Test
    @DisplayName("Getter 및 Setter 테스트")
    public void testSettersAndGetters() {
        UserSignInInputPortRequest dto = new UserSignInInputPortRequest();
        dto.setId("user123");
        dto.setPw("password123");

        assertEquals("user123", dto.getId(), "Getter를 통해 얻은 ID 필드 값이 설정한 값과 일치해야 합니다.");
        assertEquals("password123", dto.getPw(), "Getter를 통해 얻은 PW 필드 값이 설정한 값과 일치해야 합니다.");
    }
}