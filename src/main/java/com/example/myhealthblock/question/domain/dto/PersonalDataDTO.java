package com.example.myhealthblock.question.domain.dto;

import com.example.myhealthblock.question.common.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 컨트롤러 계층에서 서비스 계층으로 데이터를 전달하는 DTO 클래스 </b>
 * <br>- 사용자 로그인 시 필요한 정보
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDataDTO {
    int age;
    Gender gender;
    String disease;
    String medication;
}
