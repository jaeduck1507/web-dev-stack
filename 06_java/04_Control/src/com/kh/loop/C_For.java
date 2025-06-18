package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class C_For {

	Scanner sc = new Scanner(System.in);

	/*
	 * for문
	 * 
	 * for(초기식; 조건식; 증감식) { 실행 코드 }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문 - 초기식: 반복문이 수행될 때 단 한번만 실행, 반복문 안에서 사용할 변수를 선언하고
	 * 초기값 대입 - 조건식: 결과가 true이면 시행 코드를 실행, false이면 실행하지 않고 반복문을 빠져나감 - 증감식: 반복문에서
	 * 사용하는 변수의 값을 증감
	 */
	// 1~5 출력
	public void method1() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	// 1~5 반대로
	public void method2() {
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}

	// 1~ 10 사이의 홀수만 출력
	public void method3() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1)
				System.out.println(i);
		}

//		for(int i = 1; i <= 10; i+=2) {
//			System.out.println(i);
//		}

//		for(int i = 1; i <= 10; i++) {
//			if(i % 2 == 0) continue;
//			System.out.println(i);
//		}
//		

		/*
		 * continue 문 - continue문은 반복문 안에서 사용 - 반복문 안에서 continue를 만나면 "현재 구문" 종료 - 반복문을
		 * 빠져나가는 건 아님! 다음 반복 계속 수행
		 * 
		 */

	}

	// 1 ~ 10 합
	public void method4() {
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			sum += i;
		}

		System.out.println(sum);
	}

	// 1부터 사용자가 입력한 수까지 합
	public void method5() {
		int sum = 0;

		System.out.print("수 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		System.out.println(sum);
	}

	// 1부터 랜덤값(2 ~ 10)까지의 합계
//	Random r = new Random();
	public void method6() {
		int random = (int) (Math.random() * 9 + 2); // 10까지
		int sum = 0;

		Random random2 = new Random();
		int random3 = random2.nextInt(9) + 2; // 0 ~ 9까지

		for (int i = 1; i <= random; i++) {
			sum += i;
		}

		System.out.println(random);
		System.out.println(sum);
//		System.out.println("Random.nextInt(2,11) : " + r.nextInt(2,11));

	}

	/*
	 * 사용자한테 입력받은 문자열을 세로로 출력 사용자 입력 > hello h e ...
	 * 
	 */
	public void method7() {
		System.out.print("사용자 입력 > ");
		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		/*
		 * 향상된 for문 for(데이터타입 변수 : 배열) { 변수 : 배열의 값을 하나씩 가지고 옴 }
		 * 
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열 - toCharArray : 모든 문자가 들어 있는 char[] 형식의
		 * 데이터 반환 - charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환
		 * 
		 */
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			System.out.println(ch);
		}

	}

	// 중첩 for문
	/*
	 * ***** 
	 * ***** 
	 * ***** 
	 * *****
	 * 
	 */
	public void method8() {
		for (int i = 1; i <= 4; i++) {

			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

	/*
	 * 1**** 
	 * *2*** 
	 * **3** 
	 * ***4* 
	 * ****5
	 */
	public void method9() {
		for (int i = 1; i <= 5; i++) {

			for (int j = 0; j < i; j++) {

				System.out.print("*");
			}

			System.out.println();
		}

	}

	/*
	 * 
	 * * 
	 * ** 
	 * *** 
	 * **** 
	 * *****
	 * 
	 * 
	 */
	public void method10() {
		for (int i = 1; i <= 5; i++) {

			for (int j = 0; j < i; j++) {

				System.out.print("*");
			}

			System.out.println();
		}

	}
	/*
	 *     *
	 * 	  **
	 *   ***
	 *  ****
	 * *****
	 * */
	
	public void method11() {
		for (int i = 5; i >= 1; i--) {

			for (int j = 1; j <= 5; j++) {
				if(i <= j) System.out.print("*");
				else System.out.print(" ");
			}

			System.out.println();
		}
		
//		String a = "";
//		for (int i = 1; i <= 5; i++) {
//			a = "";
//			for (int j = 0; j < i; j++) {
//				a+= "*";				
//			}
//			System.out.printf("%5s",a);
//			System.out.println();
//		}
		
	}
	// 4 3 2 1 0
	public void method12() {
		for (int i = 21; i >= 1; i-=2) {
			
			for (int k = i/2; k >0; k--) {
				System.out.print(" ");
			}
			
			for (int j = 21; j >= i; j--) {

				System.out.print("*");
			}

			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
//		c.method11();
		c.method12();

	}

}
