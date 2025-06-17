package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * if문
	 * 
	 * if(조건식) {
	 * 		조건식이 참(true)일때 실행
	 * } else {
	 * 		조건식이 거짓일때 실행
	 * }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * */
	
	
	public void method1() {
		// 입력받은 성적이 60점이상 합격입니다 출력
		// 아니면 불합격입니다 출력
		
		System.out.print("성적 입력 : ");
		int score = sc.nextInt();
		sc.nextLine();
		if(score >= 60) System.out.println("합격입니다."); 
		else System.out.println("불합격입니다.");
		
		// 삼항연산자
		System.out.println(score >= 60 ? "합격입니다." : "불합격입니다.");
		
		
		
	}
	
	public void method2() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 본인이 아니다.
		String name = "오재덕";
		System.out.print("이름 입력 : ");
		String inputName = sc.nextLine();
		if(name.equals(inputName)) {
			System.out.println("본인입니다");
		}
		else {
			System.out.println("본인이 아닙니다.");
		}
		
	}
	/*
	 * if - else if - else 문
	 * 
	 * if(조건식1) {
	 * 		조건식1이 참일때 실행
	 * } else if(조건식2) {
	 * 		조건식 2가 거짓 조건식2 참일때
	 * } else {
	 * 		조건식 1,2가 모두 거짓일때 실행
	 * }
	 * 	
	 * - else if는 수가 제한이 없다.
	 * 
	 * */
	
	
	/*
	 * 사용자에게 점수 (0~100)를 입력받아서 점수별로 등급 출력
	 * - 90점 이상 A등급 
	 * - 90점 미만 80점 이상 b
	 * - 80점 미만 70이상 c
	 * - 70점 미만 60점 이상은 d 등급
	 * -60점 미만은 f
	 * */
	
	public void method3() {
		char grade = '\u0000';
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		sc.nextLine();
		if(score >100 || score < 0) {
			System.out.println("잘못입력");
			return;
		}
		if(score >= 90) grade = 'A';
		else if(score >= 80) grade = 'B';
		else if(score >= 70) grade = 'C';
		else if(score >= 60) grade = 'D';
		else grade ='F';
		System.out.printf("%s등급입니다",grade);
	}
	/*
	 * 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * num1 입력 : 3
	 * num2 입력 : 4
	 * num3 입력 : 8
	 * 4 8
	 * 
	 * */
	public void method4() {
		System.out.print("정수1 입력 : ");
		int n1 = sc.nextInt();
		sc.nextLine();
		System.out.print("정수2 입력 : ");
		int n2 = sc.nextInt();
		sc.nextLine();
		System.out.print("정수3 입력 : ");
		int n3 = sc.nextInt();
		sc.nextLine();
		
		if(n1 % 2 == 0) System.out.println(n1);
		if(n2 % 2 == 0) System.out.println(n2);
		if(n3 % 2 == 0) System.out.println(n3);
		
		
	}
	
	public static void main(String[] args) {
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}

}
