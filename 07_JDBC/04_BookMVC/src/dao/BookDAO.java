package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Book;

public class BookDAO {
private static BookDAO instance = new BookDAO();
	
	private BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static BookDAO getInstance() {
		return instance;
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		ArrayList<Book> list = new ArrayList<Book>();
		Connection connect = connect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Book(rs.getInt("book_no"),rs.getString("title"),rs.getString("author"),rs.getInt("access_age")));
		}
		
		close(rs, ps, connect);
		
		return list;
	}
	
	// 2. 책 등록
	public void registerBook(String title, String author, int accessAge) throws SQLException {
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안되게!
		
		Connection connect = connect();
		
		
		String query = "INSERT INTO book(title, author, access_age) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		ps.executeUpdate();
		close(ps, connect);
		
		
	}
	
	// 책 등록할때 동일한 책이 있는 경우 체크!
	public boolean checkSameBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT * FROM book WHERE title = ? and author = ? and access_age = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		
		ResultSet rs = ps.executeQuery();
		boolean checking = rs.next();
		close(rs, ps, connect);
		return checking;
	}
	
	// 3. 책 삭제
	public boolean sellBook(int bookNo) throws SQLException {
		
		Connection connect = connect();
		
		String query = "DELETE FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ps.executeUpdate();
		close(ps, connect);
		
		
		return true;
		
	}
	
}
