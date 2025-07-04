package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.BookController;
import dao.BookDAO;
import vo.Book;

class BookControllerTest {

	private BookDAO dao;
	private BookController bc = new BookController();
	
	@BeforeEach
	void setUp() throws SQLException {
		dao = BookDAO.getInstance();
		dao.registerBook("title01", "author01", 1);

	}

	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM book").executeUpdate();
	}
	
	@Test
	void testPrint() {
		ArrayList<Book> list = bc.printBookAll();
		assertEquals(list.size(), 1);
	}
	
	@Test
	void testRegisterBook() {
		bc.registerBook("title02", "author02", 1);
		ArrayList<Book> list = bc.printBookAll();
		assertEquals(list.size(), 2);
	}

	@Test
	void testRegisterSameBook() {
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안되는지 체크!
		assertTrue(bc.registerBook("title01", "author01", 1).equals("이미 동일한 책이 있습니다!!"));
		ArrayList<Book> list = bc.printBookAll();
		assertEquals(list.size(), 1);
	}
	
	@Test
	void testSellBook() {
		ArrayList<Book> list = bc.printBookAll();
		assertTrue(bc.sellBook(list.get(0).getBookNo()));
		list = bc.printBookAll();
		assertEquals(list.size(), 0);
	}
}
