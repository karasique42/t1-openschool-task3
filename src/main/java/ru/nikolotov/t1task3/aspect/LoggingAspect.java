package ru.nikolotov.t1task3.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut()
    public void pointcut() {

    }

    @Before("execution(@ru.nikolotov.t1task3.aspect.Logged * * (..))")
    public void logArguments(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        for (Object arg : args) {
            sb.append(arg.toString())
                    .append(' ')
                    .append(arg.getClass().getSimpleName())
                    .append('\n');
        }
        log.info("Method '{}' of class {} received args {}", methodSignature.getMethod().getName(),
                methodSignature.getMethod().getDeclaringClass(), sb);
    }

    @AfterReturning(value = "execution(@ru.nikolotov.t1task3.aspect.Logged * * (..))",
            returning = "returnValue")
    public void logReturnValue(JoinPoint joinPoint, Object returnValue) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Method '{}' of class {} returned value {}", methodSignature.getMethod().getName(),
                methodSignature.getMethod().getDeclaringClass(), returnValue);
    }

    @AfterThrowing(value = "execution(@ru.nikolotov.t1task3.aspect.Logged * * (..))",
            throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Method '{}' of class {} thrown exception {}", methodSignature.getMethod().getName(),
                methodSignature.getMethod().getDeclaringClass(), ex.toString());
    }
}
