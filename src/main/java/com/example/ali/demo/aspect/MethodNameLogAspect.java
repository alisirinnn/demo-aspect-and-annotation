package com.example.ali.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodNameLogAspect {

    @Around("@annotation(com.example.ali.demo.annotation.MethodNameLog)")
    public Object methodNameLog(ProceedingJoinPoint pjp) throws Throwable {
        System.err.println(pjp.getSignature().getName() + " method is running..");
        return pjp.proceed();
    }

}
