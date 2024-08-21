package com.example.myhealthblock.aop;

import com.example.myhealthblock.config.LoggerConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <b> 역할: 메소드 실행 시간 로깅 Aspect </b>
 * <p>
 * </p>
 */
@Aspect
@Component
public class ExecutionTimeLoggerAspect {

    private final LoggerConfig loggerConfig;

    @Autowired
    public ExecutionTimeLoggerAspect(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    /**
     * <b> 역할: 메소드 실행 시간 로깅하는 메소드 </b>
     * <p>
     * - {@code LogExecutionTime} 어노테이션이 붙은 클래스의 메소드 실행 시간을 로깅 <br>
     * - {@code LogExecutionTime} 어노테이션이 붙은 메소드의 실행 시간을 로깅 <br>
     * - 나노초 단위로 로깅 <br>
     * </p>
     *
     * @param joinPoint 실행할 메소드의 JoinPoint
     * @return 메소드 실행 결과
     * @throws Throwable 메소드 실행 중 발생할 수 있는 예외
     */
    @Around("@within(com.example.myhealthblock.aop.LogExecutionTime) || @annotation(com.example.myhealthblock.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        LogTarget logTarget = getLogTarget(joinPoint);

        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        if(logTarget != null) {
            logMethodExecutionTime(joinPoint, logTarget, executionTime);
        }
        return result;
    }

    /**
     * <b> 역할: 로그 타겟 추출하는 메소드 </b>
     * <p>
     * - {@code LogExecutionTime} 어노테이션에서 로그 타겟을 추출 <br>
     * </p>
     *
     * @param joinPoint 메소드의 JoinPoint
     * @return {@code LogTarget} 값
     */
    private LogTarget getLogTarget(ProceedingJoinPoint joinPoint) {
        LogExecutionTime logExecutionTime = getLogExecutionTimeAnnotation(joinPoint);
        return logExecutionTime.logTarget();
    }

    /**
     * <b> 역할: LogExecutionTime 어노테이션 추출하는 메소드 </b>
     * <p>
     * - 클래스 또는 메소드에서 {@code LogExecutionTime} 어노테이션을 추출 <br>
     * </p>
     *
     * @param joinPoint 메소드의 JoinPoint
     * @return {@code LogExecutionTime} 어노테이션
     */
    private LogExecutionTime getLogExecutionTimeAnnotation(ProceedingJoinPoint joinPoint) {
        if (isClassWithLogExecution(joinPoint)) {
            return getLogExecutionTimeFromClass(joinPoint);
        }

        return getLogExecutionTimeFromMethod(joinPoint);
    }

    /**
     * <b> 역할: 클래스에 LogExecutionTime 어노테이션 여부 확인하는 메소드 </b>
     * <p>
     * - JoinPoint의 클래스에 {@code LogExecutionTime} 어노테이션이 붙어 있는지 확인 <br>
     * </p>
     *
     * @param joinPoint 메소드의 JoinPoint
     * @return {@code LogExecutionTime} 어노테이션이 클래스에 붙어 있으면 {@code true}, 그렇지 않으면 {@code false}
     */
    private boolean isClassWithLogExecution(ProceedingJoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().isAnnotationPresent(LogExecutionTime.class);
    }

    /**
     * <b> 역할: 클래스에서 LogExecutionTime 어노테이션 추출하는 메소드 </b>
     * <p>
     * - 확인된 JoinPoint의 클래스에서 {@code LogExecutionTime} 어노테이션을 추출 <br>
     * </p>
     *
     * @param joinPoint 메소드의 JoinPoint
     * @return {@code LogExecutionTime} 어노테이션
     */
    private LogExecutionTime getLogExecutionTimeFromClass(ProceedingJoinPoint joinPoint) {
        return (LogExecutionTime) joinPoint.getTarget().getClass().getAnnotation(LogExecutionTime.class);
    }

    /**
     * <b> 역할: 메소드에서 LogExecutionTime 어노테이션 추출하는 메소드 </b>
     * <p>
     * - {@code LogExecutionTime} 어노테이션을 추출 <br>
     * </p>
     *
     * @param joinPoint 메소드의 JoinPoint
     * @return 메소드에 어노테이션이 있으면 {@code LogExecutionTime} 어노테이션, 없으면 {@code null}
     */
    private LogExecutionTime getLogExecutionTimeFromMethod(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            return methodSignature.getMethod().getAnnotation(LogExecutionTime.class);
        }
        return null;
    }

    /**
     * <b> 역할: 메소드 실행 시간 로깅 메소드 </b>
     * <p>
     * - 메소드 실행 시간 로깅 <br>
     * </p>
     *
     * @param joinPoint 실행할 메소드의 JoinPoint
     * @param logTarget 로그 타겟을 정의하는 {@code LogTarget} 값
     * @param executionTime 메소드 실행 시간 (나노초 단위)
     */
    private void logMethodExecutionTime(ProceedingJoinPoint joinPoint, LogTarget logTarget, long executionTime) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String className = signature.getDeclaringType().getSimpleName();
        String parameters = getParameters(joinPoint);

        Logger logger = loggerConfig.getLogger(logTarget);
        logger.info("{}, {}, {}, {}", className, methodName, executionTime, parameters);
    }

    /**
     * <b> 역할: 파라미터를 문자열 포맷으로 만드는 메소드 </b>
     * <p>
     * </p>
     *
     * @param joinPoint 실행할 메소드의 JoinPoint
     * @return 파라미터 문자열 포맷
     */
    private String getParameters(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return Arrays.stream(args)
                .map(arg -> arg == null ? "null" : arg.getClass().getSimpleName() + ": " + arg.toString())
                .collect(Collectors.joining(", "));
    }
}