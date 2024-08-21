package com.example.myhealthblock.aop;

/**
 * <b> 역할: 로그 타겟을 정의하는 열거형 </b>
 * <p>
 * - AOP로 로그를 남기기 위한 대상 구분 <br>
 * - {@code CONTROLLER}: 컨트롤러 계층 대상 <br>
 * - {@code SERVICE}: 서비스 계층의 대상 <br>
 * - {@code ADAPTER}: 어댑터 계층의 대상 <br>
 * - {@code REPOSITORY}: 레포지토리 계층의 대상 <br>
 * - {@code ALL}: 계층 구분 없음 <br>
 * </p>
 */
public enum LogTarget {

    /** 컨트롤러 계층의 로그를 위한 타겟 */
    CONTROLLER,

    /** 서비스 계층의 로그를 위한 타겟 */
    SERVICE,

    /** 어댑터 계층의 로그를 위한 타겟 */
    ADAPTER,

    /** 레포지토리 계층의 로그를 위한 타겟 */
    REPOSITORY,

    /** 모든 계층의 로그를 위한 타겟 */
    ALL
}