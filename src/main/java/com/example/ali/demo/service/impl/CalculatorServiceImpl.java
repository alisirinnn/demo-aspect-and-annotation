package com.example.ali.demo.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.example.ali.demo.annotation.CustomProfile;
import com.example.ali.demo.annotation.MethodNameLog;
import com.example.ali.demo.service.Calculator;

@Service
@CustomProfile
public class CalculatorServiceImpl implements Calculator {

	@Override
	@CustomProfile(unit = TimeUnit.MICROSECONDS)
	public double pow(double a, double b) {
		double result = Math.pow(a, b);
		System.out.println("Pow Result: " + result);
		return result;
	}

	@Override
	@MethodNameLog
	public double sum(double a, double b) {
		double sum = a + b;
		System.out.println("Sum Result: " + sum);
		return sum;
	}

}
