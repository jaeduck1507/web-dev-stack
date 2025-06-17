package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
		o.method1();
		o.method2();
		o.method3();
		o.method4();
		o.method5();
		o.method6();
		o.method7();
		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("인원 수 : ");
		int personCount = sc.nextInt();
		sc.nextLine();
		System.out.print("연필 개수 : ");
		int pencilConut = sc.nextInt();
		sc.nextLine();
		
		int personPerPencil = pencilConut / personCount;
		int pencilRemain = pencilConut % personCount;
		System.out.println("나눠가진 연필 개수 : " + personPerPencil);
		System.out.println("남은 연필 개수 : " + pencilRemain);
		
		
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("숫자 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		System.out.println((n/100)*100);
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("숫자1 입력 : ");
		int n1 = sc.nextInt();
		sc.nextLine();
		System.out.print("숫자2 입력 : ");
		int n2 = sc.nextInt();
		sc.nextLine();
		System.out.print("숫자3 입력 : ");
		int n3 = sc.nextInt();
		sc.nextLine();
		
		System.out.println((n1==n2)&&(n2==n3));
		
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String result = n%2 ==0 ? "짝수다" : "짝수가 아니다";
		System.out.println(result);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	//123456-1234567
	//01234567
	public void method5() {
		System.out.print("주민번호 입력 : ");
		String id = sc.nextLine();
		
		switch(id.charAt(7)) {
		case '1':
		case '3':
			System.out.println("남자입니다");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다");
			break;
		default:
			System.out.println("잘못 입력했습니다.");
			
		}
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		sc.nextLine();
		if (age < 0) {
			System.out.println("나이를 잘못 입력했습니다.");
			return;
		}
		if(age > 19) System.out.println("성인입니다.");
		else if(age > 13) System.out.println("청소년입니다.");
		else System.out.println("어린이입니다.");
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.print("사과 개수 : ");
		int apple = sc.nextInt();
		sc.nextLine();
		System.out.print("바구니 크기 : ");
		int box = sc.nextInt();
		sc.nextLine();
		
		int boxCount = 0;
		
		if(apple % box != 0) {
			boxCount = apple / box +1;
		}else {
			boxCount = apple / box;
		}
		System.out.println("필요한 바구니의 수: " + boxCount);
	}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		System.out.print("초 단위 입력 : ");
		int initSecond = sc.nextInt();
		sc.nextLine();
		
		int second = initSecond % 60;
		int initMinute = initSecond /60;
		int minute = initMinute % 60;
		int hour = initMinute / 60;

		if(hour != 0) System.out.print(hour + "시간 ");
		if(minute != 0) System.out.print(minute + "분 ");
		System.out.print(second + "초");
	}
	
}