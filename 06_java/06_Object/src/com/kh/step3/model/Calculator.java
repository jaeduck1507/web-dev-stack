package com.kh.step3.model;

public class Calculator {
	
	/*
	 * 메서드(method)
	 * - 어떤 기능을 수행하는 명령문의 집합
	 * - 입력값(Parameter)을 받아서, 결과값(Return)을 돌려줄 수 있음
	 * -단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음
	 * - 하나의 메서드는 한가지 기능만 수행하도록 작성하는 것이 좋음 (SRP 원칙)
	 * - return 반환값이 없는 경우 리턴타입이 void
	 * 
	 * 리턴타입 메서드명(파라미터, ..) {
	 * 		실행문;
	 * 		return 반환값
	 * }
	 * */
	public int a;
	public int b;
	
	// 더하기
	public int add() {
		
		return a + b;
	}
	
	//빼기 : substract
	public int substract() {
		return a - b;
		
	}
	
	// 곱하기 : multiply
	public int multiply(int a, int b) {
		return a * b;
	}
	
	
	/*
	 * 
	 * 인스턴스(객체) 메서드 : 인스턴스 변수나 인스턴스 메서드와 관련된 작업을 하는 메서드
	 * 클래스(static) 메서드 : static 변수나 static 메서드와 관련된 작업을 하는 메서드
	 * 
	 * 
	 * */
	
	
	// 나누기 : divide
	// 몫은 12, 나머지 3
	public static String divide(int a, int b) {
		
		String result =String.format("몫은 %d, 나머지는 %d", quotient(a,b), remainder(a,b));
		
		return result;
	}
	// 두수의 몫을 구하는 기능
	public static int quotient(int a, int b) {
		return a / b;
	}
	
	// 두수의 나머지를 구하는기능
	public static int remainder(int a, int b) {
		return a % b;
	}
	
	
	/*
	 * 팩토리얼!
	 * 1! = 1
	 * 2! = 2X1 = 2
	 * 3! 3X2X1 = 6;
	 * 
	 * 
	 * */
	
	public int factorial(int n) {
		int result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	
	/*
	 * 재귀법, 재귀 함수(Recursion Function)
	 * - 메서드 내에서 자기자신 호출
	 * -반복문 바꾸기 가능 성능 나쁠때 많음
	 * -이해하면 간결한 코드 작성 가능
	 * 
	 * */
	public int factorial2(int n) {
		int result = 1;
		
		if(n!=1) result = n* factorial2(n-1);
		
		return result;
	}
	
}
