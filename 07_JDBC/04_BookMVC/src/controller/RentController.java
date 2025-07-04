package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.RentDAO;
import vo.Member;
import vo.Book;
import vo.Rent;

public class RentController {
	
	private RentDAO dao = RentDAO.getInstance();
	// 로그인된 경우만 접근 가능! -> View에서 조건 걸어서 안보이게 하면 됨!

	// 7. 책 대여
	public String rentBook(Member member, Book book) {
		// 한 사람 당 대여할 수 있는 책은 총 5권
		
		// 중복 책 대여 불가능
		
		// 나이 제한 걸리는 책도 대여 불가능
		
		// 각 책들마다 가능한 대여가 2권까지만 
		
		try {
			if(dao.checkMemberRentCnt(member.getId()) == 5) return "이미 책을 5권 빌리셨습니다....";
			if(dao.checkMemberRentSameBook(member.getId(), book.getBookNo())) return "동일한 책을 대여하셨습니다..";
			if(dao.checkBookRentCnt(book.getBookNo()) == 2) return "해당 책은 모두 대여되었습니다...";
			if(member.getAge() < book.getAccessAge()) return "나이에 의해 대여가 제한됩니다...";
			return  book.getTitle() + " "+ dao.rentBook(member.getId(), book.getBookNo());
		} catch (SQLException e) {
			e.printStackTrace();
			return "오류로 인해 대여 실패!";
		}
		
		
	}
	
	// 8. 내가 대여한 책 조회
	public ArrayList<Book> printRentBook(String id) {
		try {
			return dao.printRentBook(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Book>();
		}
	}
	
	// 9. 대여 취소
	public void deleteRent(String id, int bookNo) {
		try {
			dao.deleteRent(id, bookNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
