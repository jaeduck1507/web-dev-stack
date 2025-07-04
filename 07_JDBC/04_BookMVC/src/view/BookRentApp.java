package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member client = new Member();

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		while (true) {
			System.out.println("\n----- 메뉴 -----");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.print("선택 > ");
		try {
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					printBookAll();
					break;
				case 2:
					register();
					break;
				case 3:
					login();
					break;
				default:
					System.out.println("\n입력이 잘못되었습니다.\n");
					break;
				}
		} catch(NumberFormatException e) {
			System.out.println("\n입력이 잘못되었습니다.\n");
			
		}
		}
		

	}
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		
		ArrayList<Book> list = bc.printBookAll();
		if(list.size() ==0) {
			System.out.println("\n등록된 책이 없습니다!\n");
			return list;
		}
		System.out.println("\n---- 전체 책 목록 ----");
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + ". " + list.get(i));
		}
		return list;
	}
	
	// 2. 회원가입
	public void register() throws NumberFormatException{
		Member member = new Member();
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		if(id.equals("admin")) {
			System.out.println("\n관리자 아이디(admin)으로 아이디 생성이 불가능합니다.\n");
			return;
		}
		member.setId(id);
		System.out.print("이름 > ");
		member.setName(sc.nextLine());
		System.out.print("비밀번호 > ");
		member.setPwd(sc.nextLine());
		System.out.print("나이 > ");
		member.setAge(Integer.parseInt(sc.nextLine()));
		
		try {
			mc.register(member);
			System.out.println("\n회원가입 성공!\n");
		} catch (SQLException e) {
			System.out.println("\n회원가입 실패!!\n");
		}
	}
	
	// 3. 로그인
	public void login() {
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("비밀번호 > ");
		String pwd = sc.nextLine();
		
		client = mc.login(id, pwd);
		if(client == null) {
			client = new Member();
			System.out.println("\n회원정보가 없습니다.\n");
			return;
		}
		System.out.println("\n로그인 성공!!\n");
		if(client.getId().equals("admin")) {
			adminLogin();
		}
		else {
			nomalLogin();
		}
		
	}
	
	public void adminLogin() {
		// 관리자로 로그인 했을 때
		while(true) {
			System.out.println("\n---- 관리자 모드 ----");
			System.out.println("1. 책 등록");
			System.out.println("2. 책 삭제");
			System.out.println("3. 로그아웃");
			System.out.print("\n선택 > ");
			try {
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					registerBook();
					break;
					
				case 2:
					sellBook();
					break;
					
				case 3:
					logout();
					return;
				}
			} catch(NumberFormatException e) {
				System.out.println("\n숫자만 입력해주세요!\n");
			}
			
		}
	}
	
	public void nomalLogin() {
		// 일반회원이 들어왔을 때
		while(true) {
			System.out.println("\n-----" + client.getName() +"님의 마이페이지-----");
			System.out.println("1. 회원탈퇴 ");
			System.out.println("2. 로그아웃");
			System.out.println("3. 책 대여");
			System.out.println("4. 내가 대여한 책 조회");
			System.out.println("5. 대여 취소");
			System.out.print("\n선택 > ");
			
			try {
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					delete();
					return;
					
				case 2:
					logout();
					return;
					
				case 3:
					rentBook();
					break;
					
				case 4:
					printRentBook();
					break;
					
				case 5:
					deleteRent();
					
					break;
				
				default:
					System.out.println("\n입력이 잘못되었습니다.\n");
					break;
					
				}
			} catch(NumberFormatException e) {
				System.out.println("\n입력이 잘못되었습니다.\n");
			}
			
			
		}
	}
	
	
	public void registerBook() throws NumberFormatException {
		// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
		System.out.print("책 제목 > ");
		String title = sc.nextLine();
		System.out.print("저자 > ");
		String author = sc.nextLine();
		System.out.print("제한 나이 > ");
		int accessAge = Integer.parseInt(sc.nextLine());
		System.out.println(bc.registerBook(title, author, accessAge));
	}

	public void sellBook() throws NumberFormatException {
		// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
		ArrayList<Book> list = printBookAll();
		if(list.size() ==0) return;
		
		System.out.print("삭제할 책의 번호 입력 > ");
		int num = Integer.parseInt(sc.nextLine());
		if(num < 1 || num > list.size()) {
			System.out.println("\n입력이 잘못되었습니다.\n");
			return;
		}
		boolean checkSell = bc.sellBook(list.get(num - 1).getBookNo());
		if(checkSell) System.out.println("\n책 삭제 완료!\n");
		else System.out.println("\n책이 대여되어 삭제 실패\n");
	}
	
	public void delete() {
		// 1. 회원탈퇴 - 로그인 O (관리자 X)
		mc.delete(client.getId());
		client = new Member();
		System.out.println("\n회원탈퇴 완료!!\n");
	}
	
	public void logout() {
		// 2. 로그아웃 - 로그인 O
		client = new Member();
		System.out.println("\n로그아웃 완료\n");
	}
	
	public void rentBook() throws NumberFormatException {
		// 3. 책 대여 - 로그인 O
		ArrayList<Book> list = printBookAll();
		if(list.size() ==0) return;
		
		System.out.print("대여할 책의 번호 입력 > ");
		int num = Integer.parseInt(sc.nextLine());
		if(num < 1 || num > list.size()) {
			System.out.println("\n입력이 잘못되었습니다.\n");
			return;
		}
		
		Book book = list.get(num - 1);
		System.out.println(rc.rentBook(client, book));
	}
	
	public void printRentBook() {
		// 4. 내가 대여한 책 조회 - 로그인 O
		ArrayList<Book> list = rc.printRentBook(client.getId());
		if(list.size() == 0) {
			System.out.println("\n대여한 책이 없습니다!\n");
			return;
		}
		System.out.println(list);
	}
	
	public void deleteRent() throws NumberFormatException {
		// 5. 대여 취소 - 로그인 O
		ArrayList<Book> list = rc.printRentBook(client.getId());
		if(list.size() ==0) {
			System.out.println("\n대여한 책이 없습니다!\n");
			return;
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i +1) + ". " + list.get(i));
		}
		
		System.out.print("대여 취소할 책의 번호 입력 >");
		int num = Integer.parseInt(sc.nextLine());
		if(num < 1 || num > list.size()) {
			System.out.println("\n입력이 잘못되었습니다.\n");
			return;
		}
		rc.deleteRent(client.getId(),list.get(num - 1).getBookNo());
		System.out.println("\n대여 취소 완료 !!\n");
	}
	
	

}