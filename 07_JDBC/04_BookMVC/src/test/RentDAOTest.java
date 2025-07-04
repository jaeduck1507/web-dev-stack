package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO;
import dao.MemberDAO;
import dao.RentDAO;
import vo.Book;
import vo.Member;

class RentDAOTest {

	private RentDAO dao;
	private MemberDAO mDao;
	private BookDAO bDao;
	
	@BeforeEach
	void setUp() throws SQLException {
		dao = RentDAO.getInstance();
		mDao = MemberDAO.getInstance();
		bDao = BookDAO.getInstance();
		mDao.register(new Member("test01","테스트01","pass01", 1));
		mDao.register(new Member("test02","테스트02","pass02", 1));
		
		
		
		
	}

	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM rent").executeUpdate();
		MemberDAO.getInstance().connect().prepareStatement("DELETE FROM member").executeUpdate();
		BookDAO.getInstance().connect().prepareStatement("DELETE FROM book").executeUpdate();
		
	}
	
	@Test
	void testRentBook() throws SQLException {
		bDao.registerBook("title01", "author01", 1);
		ArrayList<Book> list = bDao.printBookAll();	
		
		dao.rentBook("test01", list.get(0).getBookNo());
		assertEquals(list.size(), 1);
	}
	
	@Test
	void testCheckMemberRentCnt() throws SQLException {
		// 5권보다 더 많이 빌리는지 체크!
		bDao.registerBook("title01", "author01", 1);
		bDao.registerBook("title02", "author02", 1);
		bDao.registerBook("title03", "author03", 1);
		bDao.registerBook("title04", "author04", 1);
		bDao.registerBook("title05", "author05", 1);
		
		ArrayList<Book> list = bDao.printBookAll();	
		for(Book b : list) {
			dao.rentBook("test01", b.getBookNo());
		}
		assertEquals(dao.checkMemberRentCnt("test01"), 5);
		
	}
	
	@Test
	void testCheckMemberRentSameBook() throws SQLException {
		// 같은 책을 빌리는지 체크!
		bDao.registerBook("title01", "author01", 1);
		ArrayList<Book> list = bDao.printBookAll();	
		
		dao.rentBook("test01", list.get(0).getBookNo());
		assertTrue(dao.checkMemberRentSameBook("test01", list.get(0).getBookNo()));
	}
	
	@Test
	void testCheckBookRentCnt() throws SQLException {
		// 이미 책이 2권 대여되어 있는지 체크!
		bDao.registerBook("title01", "author01", 1);
		ArrayList<Book> list = bDao.printBookAll();	
		dao.rentBook("test01", list.get(0).getBookNo());
		dao.rentBook("test02", list.get(0).getBookNo());
		assertEquals(dao.checkBookRentCnt(list.get(0).getBookNo()), 2);
		
	}
	
	@Test
	void testPrintRentBook() throws SQLException {
		bDao.registerBook("title01", "author01", 1);
		bDao.registerBook("title02", "author02", 1);
		bDao.registerBook("title03", "author03", 1);
		bDao.registerBook("title04", "author04", 1);
		bDao.registerBook("title05", "author05", 1);
		ArrayList<Book> list = bDao.printBookAll();	
		for(Book b : list) {
			dao.rentBook("test01", b.getBookNo());
		}
		list = dao.printRentBook("test01");
		assertEquals(list.size(), 5);
	}
	
	@Test
	void testDeleteRent() throws SQLException {
		bDao.registerBook("title01", "author01", 1);
		ArrayList<Book> list = bDao.printBookAll();	
		int bookNo = list.get(0).getBookNo();
		dao.rentBook("test01", bookNo);
		dao.deleteRent("test01", bookNo);
		list = dao.printRentBook("test01");
		assertEquals(list.size(), 0);
		
		
	}
	
	
}
