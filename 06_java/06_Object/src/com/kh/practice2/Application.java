package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SnackController controller = new SnackController();
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.println(controller.saveData(kind, name, flavor, numOf, price));
		System.out.println(controller.confirmData());
		
		
	}

}
