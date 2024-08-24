package com.example.myhealthblock.config;

import com.example.myhealthblock.aop.LogTarget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b> 역할: 로거 팩토리 클래스 </b>
 * <p>
 * - 로그 타겟에 따라 적절한 로거 인스턴스 반환 <br>
 * - AOP 실행 시간 측정할 때 사용  <br>
 * </p>
 */
@Configuration
public class LoggerConfig {

    /**
     * <b> 역할: Controller 계층 Logger 생성 </b>
     * <p>
     * - {@code controller-logger} 이름의 Logger 인스턴스 생성 <br>
     * </p>
     *
     * @return Controller 계층 Logger 객체
     */
    @Bean
    public Logger controllerLogger() {
        return LogManager.getLogger("controller-logger");
    }

    /**
     * <b> 역할: Service 계층 Logger 생성 </b>
     * <p>
     * - {@code service-logger} 이름의 Logger 인스턴스 생성 <br>
     * </p>
     *
     * @return Service 계층 Logger 객체
     */
    @Bean
    public Logger serviceLogger() {
        return LogManager.getLogger("service-logger");
    }

    /**
     * <b> 역할: Repository 계층 Logger 생성 </b>
     * <p>
     * - {@code repository-logger} 이름의 Logger 인스턴스 생성 <br>
     * </p>
     *
     * @return Repository 계층 Logger 객체
     */
    @Bean
    public Logger repositoryLogger() {
        return LogManager.getLogger("repository-logger");
    }

    /**
     * <b> 역할: Adapter 계층 Logger 생성 </b>
     * <p>
     * - {@code adapter-logger} 이름의 Logger 인스턴스 생성 <br>
     * </p>
     *
     * @return Adapter 계층 Logger 객체
     */
    @Bean
    public Logger adapterLogger() {
        return LogManager.getLogger("adapter-logger");
    }

    /**
     * <b> 역할: 로그 타겟에 따라 로거 반환 </b>
     * <p>
     * - {@code LogTarget} 열거형에 따라 적절한 로거 반환 <br>
     * </p>
     *
     * @param logTarget 로그 타겟을 정의하는 {@code LogTarget} 값
     * @return 해당 로그 타겟의 {@code Logger} 인스턴스
     */
    public Logger getLogger(LogTarget logTarget) {
        switch (logTarget) {
            case CONTROLLER:
                return controllerLogger();
            case SERVICE:
                return serviceLogger();
            case ADAPTER:
                return adapterLogger();
            case REPOSITORY:
                return repositoryLogger();
            default:
                return null;
        }
    }
}