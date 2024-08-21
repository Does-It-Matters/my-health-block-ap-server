//package com.example.myhealthblock.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * <b> 역할: logger 설정 클래스 </b>
// * <br>- 계층에 맞는 Logger 인스턴스 등록
// */
//@Configuration
//public class LoggingConfig {
//
//    /**
//     * <b> 역할: Controller 계층 Logger 등록하는 메소드 </b>
//     *
//     * @return Controller 계층 Logger 객체
//     */
//    @Bean
//    public Logger controllerLogger() {
//        return LoggerFactory.getLogger("controller-logger");
//    }
//
//    /**
//     * <b> 역할: Service 계층 Logger 등록하는 메소드 </b>
//     *
//     * @return Service 계층 Logger 객체
//     */
//    @Bean
//    public Logger serviceLogger() {
//        return LoggerFactory.getLogger("service-logger");
//    }
//
//    /**
//     * <b> 역할: Repository 계층 Logger 등록하는 메소드 </b>
//     *
//     * @return Repository 계층 Logger 객체
//     */
//    @Bean
//    public Logger repositoryLogger() {
//        return LoggerFactory.getLogger("repository-logger");
//    }
//
//    /**
//     * <b> 역할: Adapter 계층 Logger 등록하는 메소드 </b>
//     *
//     * @return Adapter 계층 Logger 객체
//     */
//    @Bean
//    public Logger adapterLogger() {
//        return LoggerFactory.getLogger("adapter-logger");
//    }
//}
