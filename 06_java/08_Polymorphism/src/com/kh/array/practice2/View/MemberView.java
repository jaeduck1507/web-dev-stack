package com.kh.array.practice2.View;

import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class MemberView {
	private MemberController c = new MemberController();
	Scanner sc = new Scanner(System.in);
	boolean flag = true;
	
	public void enroll() {
		
		while(flag) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.printf("현재 등록된 회원 수는 %d명입니다.\n",c.getCount());
			if(c.getCount() <= 2) System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int n = sc.nextInt();
			sc.nextLine();
			
			switch(n) {
			case 1:
				if(c.getCount() <= 2) newEnroll();
				else System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			case 2:
				modifyInfo();
				break;
			case 3:
				showInfo();
				break;
			case 9:
				System.out.println("프로그램 종료");
				flag = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}
			
		}
	}
	
	public void newEnroll() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		if(c.idIsSame(id) != -1) {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요");
			newEnroll();
			return;
		}
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("성별 : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		c.enroll(id, name, pwd, email, gender, age);
		c.countPlus();
	}
	
	public void modifyInfo() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		int n = c.idIsSame(id);
		
		if(n == -1) {
			System.out.println("회원 정보가 없습니다.");
			return;
		}
		
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		
		c.enroll(id, name, pwd, email,n);	
		
	}
	
	public void showInfo() {
		for (Member m : c.getArr()) {
			if(m != null) System.out.println(m);
		}
	}
	
}
