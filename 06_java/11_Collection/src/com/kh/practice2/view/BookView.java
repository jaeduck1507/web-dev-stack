package com.kh.practice2.view;

import java.util.*;

import com.kh.practice2.controller.BookController;

public class BookView {
	BookController bc = new BookController();
	Scanner sc = new Scanner(System.in);
	boolean flag;
	public void mainView() {
		flag = true;
		bc.addBook();
		while(flag) {
			memberLogion();
			mainMenu();
			
		}
		System.out.println(bc.getMemberList());
	}
	
	public void memberLogion() {
		while(true) {
			try {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				if(bc.checkLogin(name, age)) return;
				else System.out.println("이미 존재하는 이름입니다. 다시 입력해주실래요?");
			} catch(Exception e) {
				System.out.println("나이에 숫자를 입력해주세요!!");
				
			}
					
		}
	}
	
	public void mainMenu() {
		while(true) {
			try {
				System.out.println("==== 메뉴 ====");
				System.out.println("1. 마이페이지 ");
				System.out.println("2. 도서 대여하기");
				System.out.println("3. 로그아웃");
				System.out.println("4. 프로그램 종료");
				System.out.print("메뉴 번호 : ");
				int n = Integer.parseInt(sc.nextLine());
				
				switch(n) {
				case 1:
					myPage();
					break;
				case 2:
					bookRental();
					break;
				case 3:
					return;
				case 4:
					this.flag = false;
					return;
					
				default:
					System.out.println("메뉴 번호가 올바르지 않습니다.");
					break;
				}
			} catch(Exception e) {
				System.out.println("메뉴 번호가 올바르지 않습니다.");
			}									
		}
	}
	
	public void myPage() {
		System.out.println(bc.showInfo());
	}
	
	public void bookRental() {
		try {
			for(int i = 0; i < bc.getBooks().size(); i++) {
				System.out.println((i+1) +"번 도서 : " + bc.getBooks().get(i).toString());
			}
			System.out.print("대여할 도서 번호 선택 : ");
			int n = Integer.parseInt(sc.nextLine());
			if(n >bc.getBooks().size() || n <= 0) {
				System.out.println("입력이 올바르지 않습니다.");
				return;
				
			}
			switch(bc.bookRental(n)) {
			case 0:
				System.out.println("성공적으로 대여되었습니다");
				break;
			case 1:
				System.out.println("더 이상 대여할 수 없습니다.");
				break;
			case 2:
				System.out.println("이미 대여한 책입니다.");
				break;
			case 3:
				System.out.println("나이 제한으로 대여 불가능합니다.");
				break;
			case 4:
				System.out.println("책이 모두 대여되어 대여할 수 없습니다.");
				break;
			}
			
			
		} catch(Exception e) {
			System.out.println("입력이 올바르지 않습니다.");
		}
	}
	
	
	
}
