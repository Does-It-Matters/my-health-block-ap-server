package com.example.myhealthblock.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b> 역할: 메소드 실행 시간을 로그로 남기기 위한 어노테이션 </b>
 * <p>
 * - AOP를 통해 메소드 실행 시간을 로그로 남길 때 사용 <br>
 * - {@code logTarget} 속성을 통해 로그 타겟 설정 <br>
 * </p>
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // 클래스, 인터페이스에 적용 가능
@Retention(RetentionPolicy.RUNTIME) // 런타임 시에도 어노테이션 정보 유지
public @interface LogExecutionTime {

    /**
     * <b> 역할: 로그를 남길 타겟 지정 </b>
     * <p>
     * - {@code LogTarget} 열거형으로 로그 타겟 설정 <br>
     * - 기본값은 {@code LogTarget.ALL}로 지정 <br>
     * </p>
     *
     * @return 로그 타겟을 정의하는 {@code LogTarget} 값
     */
    LogTarget logTarget() default LogTarget.ALL;
}
