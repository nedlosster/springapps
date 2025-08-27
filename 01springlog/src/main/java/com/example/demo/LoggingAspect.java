package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("@annotation(LogExecution)") 
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("➡️ Вызов метода: {} с аргументами: {}", methodName, args);

        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed(); 
            long executionTime = System.currentTimeMillis() - startTime;
            log.info("✅ Метод: {} выполнен успешно за {} мс. Результат: {}", methodName, executionTime, result);
            return result;
        } catch (Exception e) {
            long executionTime = System.currentTimeMillis() - startTime;
            log.error("❌ Метод: {} завершился с ошибкой за {} мс. Исключение: {}", methodName, executionTime, e.getMessage(), e);
            throw e;
        }
    }
}