package com.example.myhealthblock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class ExecutionTimeLoggerAspect {

    private static final Logger controllerLogger = LogManager.getLogger("controller-logger");
    private static final Logger serviceLogger = LogManager.getLogger("service-logger");
    private static final Logger adapterLogger = LogManager.getLogger("adapter-logger");
    private static final Logger repositoryLogger = LogManager.getLogger("repository-logger");

    @Around("@within(com.example.myhealthblock.aop.LogExecutionTime) || @annotation(com.example.myhealthblock.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        LogExecutionTime logExecutionTime = getLogExecutionTimeAnnotation(joinPoint);
        LogTarget logTarget = logExecutionTime.logTarget();

        if (!isLoggingTarget(logTarget, joinPoint)) {
            return joinPoint.proceed();
        }

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String className = signature.getDeclaringType().getSimpleName();

//        System.out.println(className + "." + methodName + "() 실행 시간: " + executionTime + "ms");

        Logger logger = getLogger(logTarget);
        className = String.format("%-25s", className);
        methodName = String.format("%-25s", methodName);
        logger.info("{}, {}, {}", className, methodName, executionTime);

        return result;
    }

    private boolean isLoggingTarget(LogTarget logTarget, ProceedingJoinPoint joinPoint) {
        if (logTarget == LogTarget.ALL) {
            return true;
        }

        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        if (logTarget == LogTarget.CONTROLLER && className.endsWith("Controller")) {
            return true;
        } else if (logTarget == LogTarget.SERVICE && className.endsWith("Service")) {
            return true;
        } else if (logTarget == LogTarget.ADAPTER && className.endsWith("Adapter")) {
            return true;
        } else if (logTarget == LogTarget.REPOSITORY && className.endsWith("Repository")) {
            return true;
        }

        return false;
    }

    private LogExecutionTime getLogExecutionTimeAnnotation(ProceedingJoinPoint joinPoint) {
        LogExecutionTime logExecutionTime = null;
        if (joinPoint.getTarget().getClass().isAnnotationPresent(LogExecutionTime.class)) {
            logExecutionTime =  (LogExecutionTime) joinPoint.getTarget().getClass().getAnnotation(LogExecutionTime.class);
        } else {
            Signature signature = joinPoint.getSignature();
            if (signature.getDeclaringType().isAnnotationPresent(LogExecutionTime.class)) {
                logExecutionTime =  (LogExecutionTime) signature.getDeclaringType().getAnnotation(LogExecutionTime.class);
            }
        }
        return logExecutionTime;
    }

    private Logger getLogger(LogTarget logTarget) {
        if (logTarget == LogTarget.CONTROLLER) {
            return controllerLogger;
        } else if (logTarget == LogTarget.SERVICE) {
            return serviceLogger;
        } else if (logTarget == LogTarget.ADAPTER) {
            return adapterLogger;
        } else if (logTarget == LogTarget.REPOSITORY) {
            return repositoryLogger;
        } else {
            return null;
        }
    }
}