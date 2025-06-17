package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * switch문
	 * 
	 * switch(조건식) {
	 * 		case 값1 :
	 * 			조건식의 결과가 값1과 같은 경우 실행;
	 * 			break;
	 * 		case 값2 :
	 * 			조건식의 결과가 값2과 같은 경우 실행;
	 * 			break;
	 * 		default :
	 * 			조건식의 결과 일치하는 case문이 없을때 실행;
	 * 
	 * }
	 * 
	 * - case 문의 수는 제한이 없다
	 * - 조건식 결과는 정수, 문자, 문자열이어야 한다
	 * - 조건문을 빠져나가려면 break가 필요하다.
	 * - default문은 생략 가능
	 * */
	
	/*
	 * 숫자를 입력받아
	 * 1일 경우 "빨간색입니다"
	 * 2일 경우 파란색입니다.
	 * 3일 경우 초록색입니다
	 * 잘못입력하면 잘못입력
	 * */
	
	public void method1() {
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();
		switch(n) {
		case 1 :
			System.out.println("빨간색입니다.");
			break;
		case 2 :
			System.out.println("파란색입니다.");
			break;
		case 3 :
			System.out.println("초록색입니다.");
			break;
		default : 
			System.out.println("잘못입력했습니다");
			
		}
	}
	
	
	/*
	 * 주민번호를 입력받아 "남자" "여자" 구분 그외에는 사람아님
	 * 000000-0000000
	 * 01234567890123
	 * */
	
	public void method2() {
		System.out.print("주민번호 입력 : ");
		String id = sc.nextLine();
		
		
		if(id.charAt(6) != '-' || id.length() != 14) return;
		for(int i = 0; i<id.length(); i++) {
			if (i == 6) continue;
			if(!(id.charAt(i) >= '0' && id.charAt(i)<='9')) return;
		}
		
		
		switch(id.charAt(7)) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		default:
			System.out.println("사람이 아닙니다.");
		}
	}
	
	
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
		b.method2();
	}

}
