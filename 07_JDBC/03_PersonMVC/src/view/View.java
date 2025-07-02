package view;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.*;

import controller.PersonController;
import model.Person;

public class View {

	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		View v = new View();
		v.mainView();
		
	}
	
	public void mainView() {
		
		while(true) {
			System.out.println("\n-----------------------------person 데이터베이스 조작-----------------------------\n");
			System.out.println("1. 데이터 삽입");
			System.out.println("2. 데이터 전체 보기");
			System.out.println("3. 데이터 하나 보기");
			System.out.println("4. 데이터 수정");
			System.out.println("5. 데이터 삭제");
			System.out.println("6. 종료");
			
			System.out.print("\n번호 입력! > ");
			
			try {
				int n = Integer.parseInt(sc.nextLine());
				
				switch(n) {
				case 1:
					addPerson();
					break;
				case 2:
					searchAllPerson();
					break;
				case 3:
					searchPerson();
					break;
				case 4:
					updatePerson();
					break;
				case 5:
					removePerson();
					break;
				case 6:
					System.out.println("\n종료합니다.");
					return;
				default:
					System.out.println("\n번호를 잘못 입력하였습니다!!");
					continue;
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				continue;
			}
			
		}
	}
	
	
	public void addPerson() throws SQLException{
		System.out.println("---데이터 삽입----");
		try {
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			System.out.print("나이 입력 : ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("주소 입력 : ");
			String addr = sc.nextLine();
			
			System.out.println(pc.addPerson(name, age, addr));
			
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("정확하게 입력해주세요!");
		}
	}
	
	public void searchAllPerson() throws SQLException {
		System.out.println("\n---데이터 전체 보기---\n");
		if(pc.searchAllPerson().size() == 0) {
			System.out.println("존재하는 데이터가 없거나 불러오지 못했습니다!");
			return;
		}
		System.out.println(pc.searchAllPerson().toString());
	}
	
	public void searchPerson() throws SQLException {
		System.out.println("\n---데이터 하나 보기---\n");
		System.out.print("아이디(숫자) 입력 : ");
		try {
			int n = Integer.parseInt(sc.nextLine());
			Person p =pc.searchPerson(n);
			if(p == null) {
				System.out.println("정보가 없습니다!!");
				return;
			}
			System.out.println(p);
		} catch(Exception e) {
			System.out.println("숫자만 입력!!");
		}
	}
	
	public void updatePerson() throws SQLException {
		System.out.println("\n---데이터 수정---\n");
		System.out.println("수정할 아이디(숫자 입력 : )");
		
		try {
			int n = Integer.parseInt(sc.nextLine());
			Person p =pc.searchPerson(n);
			if(p == null) {
				System.out.println("수정할 아이디의 정보가 없습니다!!");
				return;
			}
			System.out.println("현재 정보 : " + p);
			System.out.print("변경할 이름 : ");
			String name = sc.nextLine();
			System.out.print("변경할 나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("변경할 주소 : ");
			String addr = sc.nextLine();
			
			System.out.println(pc.updatePerson(n, name, age, addr));
			
			
		} catch(Exception e) {
			System.out.println("잘못 입력!!");
		}
		
		
	}
	
	public void removePerson() throws SQLException {
		System.out.println("\n---데이터 삭제---\n");
		System.out.println("삭제할 아이디(숫자 입력 : )");
		
		try {
			int n = Integer.parseInt(sc.nextLine());
			Person p =pc.searchPerson(n);
			if(p == null) {
				System.out.println("삭제할 아이디의 정보가 없습니다!!");
				return;
			}
			
			System.out.println(pc.removePerson(n));
			
			
		} catch(Exception e) {
			System.out.println("잘못 입력!!");
		}
		
		
	}
	
	

}
