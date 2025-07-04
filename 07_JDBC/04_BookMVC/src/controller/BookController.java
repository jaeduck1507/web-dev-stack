package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {
	
	private BookDAO dao = BookDAO.getInstance();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Book>();
	}
	
	// 2. 책 등록
	public String registerBook(String title, String author, int accessAge) {
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안되게!
		try {
			if(dao.checkSameBook(title, author, accessAge)) return "이미 동일한 책이 있습니다!!";
			dao.registerBook(title, author, accessAge);
			return "책 등록 완료!";
		} catch (SQLException e) {
			e.printStackTrace();
			return "책 등록 실패!!";
		}
		
		
	}
	
	// 3. 책 삭제
	public boolean sellBook(int bookNo) {
		
		// 빌려있는 책은 삭제 못하게!
		try {
			return dao.sellBook(bookNo);
		} catch (SQLException e) {
			
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
}
