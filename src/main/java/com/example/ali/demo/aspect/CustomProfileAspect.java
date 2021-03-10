package com.example.ali.demo.aspect;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.ali.demo.annotation.CustomProfile;

@Component
@Aspect
public class CustomProfileAspect {

	@Around("@annotation(profile)")
	public Object profileForMethod(ProceedingJoinPoint pjp, CustomProfile profile) throws Throwable {

		long start = System.nanoTime();
		Object result = pjp.proceed();
		long duration = System.nanoTime() - start;

		String name = pjp.getSignature().getName();
		TimeUnit tu = profile.unit();
		long convertedDuration = tu.convert(duration, TimeUnit.NANOSECONDS);
		System.err.println("profileForMethod---->" + name + " runs at " + convertedDuration + " " + tu.name());

		return result;

	}

	@Around("@within(profile)")
	public Object profileForClass(ProceedingJoinPoint pjp, CustomProfile profile) throws Throwable {

		long start = System.nanoTime();
		Object result = pjp.proceed();
		long duration = System.nanoTime() - start;

		String name = pjp.getSignature().getName();
		TimeUnit tu = profile.unit();
		long convertedDuration = tu.convert(duration, TimeUnit.NANOSECONDS);
		System.err.println("profileForClass-->" + name + " runs at " + convertedDuration + " " + tu.name());

		return result;

	}
}
