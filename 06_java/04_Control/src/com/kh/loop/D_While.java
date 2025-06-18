package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class D_While {
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	 * 
	 * */
	// 1~5 까지 출력
	public void method1() {
		
		int i =1;
		
		while(i <= 5) {
			System.out.println(i++);
			
		}
		
	}
	
	
	/*
	 * 무한루프 & break문
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다.
	 * */
	
	public void method2() {
		while(true) {
			System.out.print("숫자 입력 > ");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.println(num);
			// num 0 인경우 중지
			if(num == 0) break;
		}
	}
	
	/*
	 * do {
	 * 		실행 코드
	 * } while(조건식);
	 * - 조건과 상관없이 무조건 한번은 실행
	 * */
	
	public void method3() {
		int number = 1;
		
		do {
			System.out.println(1);
			
		}while(number ==0);
	}
	
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값을 정답을 정하고
	 * 컴퓨터(random)가 맞히도록
	 * 몇번만에 끝내는지
	 * 해당 숫자보다 정답이 높으면 up!
	 * 낮으면 down!
	 * */
	Random r = new Random();
	public void method4() {
		int i = 0;
		System.out.print("정답 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		
		int random = r.nextInt(1,101);
		int startR = 1;
		int endR = 101;
		while(true) {
			i++;
			System.out.println(random);
			if(n == random) {
				System.out.println("정답입니다! 정답 : " + n);
				System.out.println("시도 횟수 : " + i + "회");
				break;
			} else if(n > random) {
				startR = random+1;
				System.out.println("Up!");
				random = r.nextInt(startR,endR);
				
			} else { // n < random
				endR = random;
				System.out.println("Down!");
				random = r.nextInt(startR,endR);
			}
		}
	}
	
	public void methodP() {
		int i = 0;
		System.out.print("정답 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		
		int random = r.nextInt(1,101);
		int startR = 1;
		int endR = 100;
		while(true) {
			i++;
			System.out.println(random);
			if(n == random) {
				System.out.println("정답입니다! 정답 : " + n);
				System.out.println("시도 횟수 : " + i + "회");
				break;
			} else if(n > random) {
				startR = random + 1;
				random = (random + endR) /2;
				System.out.println("Up!");
				
				
			} else { // n < random
				endR = random - 1;
				random = (random + startR) /2;
				System.out.println("Down!");
				
			}
		}
	}

	public void method5() {
		int i = 0;
		int random = r.nextInt(1,101);

		while(true) {
			System.out.print("정답 입력 : ");
			int n = sc.nextInt();
			sc.nextLine();
			
			i++;
			
			if(n == random) {
				System.out.println("정답입니다! 정답 : " + random);
				System.out.println("시도 횟수 : " + i + "회");
				break;
			} else if(n < random) {				
				System.out.println("Up!");				
			} else { // n > random			
				System.out.println("Down!");				
			}
		}
	}
	
	/*
	 * --------------------------------
	 * 1.예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------
	 * 선택 > 1
	 * 예금액 > 10000
	 * ----------------------
	 * 1.예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------
	 * 선택 > 2
	 * 출금액 > 5000
	 * 
	 * --
	 * 선택 > 3
	 * 잔고 확인 > 5000
	 * 
	 * 선택 > 4
	 * 프로그램 종료
	 * */
	
	public void method6() {
		int deposit = 0,
			depositCost = 0, 
			withdrawal = 0, 
			select = 0;
		
		while(select != 4) {
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			
			System.out.print("선택 > ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				System.out.print("예금액 > ");
				depositCost = sc.nextInt();
				sc.nextLine();
				deposit += depositCost;
				break;
			case 2:
				System.out.print("출금액 > ");
				withdrawal = sc.nextInt();
				sc.nextLine();
				if(deposit < withdrawal) {
					System.out.println("잔고 부족");
				} else {
					deposit -= withdrawal;
				}
				break;
			case 3:
				System.out.println("잔고 확인 > " + deposit);
				
				break;
			case 4:
				System.out.println("프로그램 종료");
				
				break;
			default:
				System.out.println("번호 잘못 입력");
			}
		}
	}
	
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.methodP();
//		d.method5();
		d.method6();
	}

}
