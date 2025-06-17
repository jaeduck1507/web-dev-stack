package com.kh.operator;

public class C_Arithmetic {

	public static void main(String[] args) {
		C_Arithmetic a = new C_Arithmetic();
//		a.method1();
		a.method2();
	}
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("+ : " + (num1+num2)); //13
		System.out.println("- : " + (num1-num2)); // 7
		System.out.println("* : " + (num1*num2)); // 30
		System.out.println("/ : " + (num1/num2)); // 3
		System.out.println("% : " + (num1%num2)); // 1
		
		
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b++; // 16 6 11
		int d = c/a; // d 2 a 6 b 11
		int e = c % a; // e 4 c 16 a 6
		int f = e++; // f 4 e 5
		int g = (--b) + (d--); // b10 g 12 d 1
		int h = c--*b; // h 160 c 15
		int i = (a++) +b / (--c/f) * (g-- -d) % (++e + h);
		// 5 * 10 %  165
//		 5 + 3 * 10 
		
	}
	
}
