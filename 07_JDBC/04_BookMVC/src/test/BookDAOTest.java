package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO;
import vo.Book;

class BookDAOTest {

	private BookDAO dao;
	
	@BeforeEach
	void setUp() throws SQLException {
		dao = BookDAO.getInstance();
		dao.registerBook("title01", "author01", 15);

	}

	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM book").executeUpdate();
	}
	
	@Test
	void testPrintBookAll() throws SQLException {
		ArrayList<Book> list = dao.printBookAll();
		assertEquals(list.size(), 1);
	}
	
	@Test
	void testRegisterBook() throws SQLException {
		dao.registerBook("title02", "author02", 15);
		ArrayList<Book> list = dao.printBookAll();
		assertEquals(list.size(), 2);
	}
	@Test
	void testCheckSameBook() throws SQLException {
		dao.checkSameBook("title01", "author01", 15);
		ArrayList<Book> list = dao.printBookAll();
		assertEquals(list.size(), 1);
		
	}
	
	@Test
	void testSellBook() throws SQLException {
		
		ArrayList<Book> list = dao.printBookAll();		
		assertTrue(dao.sellBook(list.get(0).getBookNo()));
		list = dao.printBookAll();	
		assertEquals(list.size(), 0);
		
//		System.out.println("testSellBook : " + dao.sellBook(list.get(0).getBookNo()));
	}
	
	
	
	
	
}
