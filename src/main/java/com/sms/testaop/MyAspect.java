package com.sms.testaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class MyAspect {
    private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void startStopWatch() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatchThreadLocal.set(stopWatch);
    }

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void logExecutionTime() {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        stopWatch.stop();
        long executionTime = stopWatch.getTotalTimeMillis();
        System.out.println("Request completed in " + executionTime + "ms");
        stopWatchThreadLocal.remove();
    }

    @Around("execution(* com.example.demo.service.*.*(..))")
    public Object logServiceExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = joinPoint.proceed();
        stopWatch.stop();
        long executionTime = stopWatch.getTotalTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className + "." + methodName + " executed in " + executionTime + "ms");
        return proceed;
    }
}
