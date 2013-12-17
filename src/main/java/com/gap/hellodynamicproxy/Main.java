package com.gap.hellodynamicproxy;

import com.gap.hellodynamicproxy.Calculator;
public class Main {

	public static void main(String[] args) {
		int result;
		
		Calculator calcWithoutLogging = new CalculatorImpl();
		result = calcWithoutLogging.add(1, 1);
		System.out.println("result without logging="+result);
		
		Calculator calcWithLogging =  (Calculator) LoggingProxy.newInstance(new CalculatorImpl());
		result = calcWithLogging.add(1, 1);
		System.out.println("result with logging="+result);
	}

}
