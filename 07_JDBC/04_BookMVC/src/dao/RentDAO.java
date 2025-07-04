package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Rent;
import vo.Book;

public class RentDAO {

private static RentDAO instance = new RentDAO();
	
	private RentDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static RentDAO getInstance() {
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
	
	// 7. 책 대여
	public String rentBook(String id, int bookNo) throws SQLException {
		
		Connection connect = connect();
		String query = "INSERT INTO rent(id, book_no) VALUES(?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		ps.executeUpdate();
		close(ps, connect);
		return "대여 완료 !!";
		
	}
	
	// 5권보다 더 많이 빌리는지 체크!
	public int checkMemberRentCnt(String id) throws SQLException {
		Connection connect = connect();
		String query = "SELECT count(id) AS cnt FROM rent WHERE id = ? GROUP BY id";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int count = rs.getInt("cnt");
			close(rs, ps, connect);
			return count;
		}
		close(rs, ps, connect);
		return 0;
		
	}
	
	// 같은 책을 빌리는지 체크!
	public boolean checkMemberRentSameBook(String id, int bookNo) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM rent WHERE id = ? and book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		ResultSet rs = ps.executeQuery();
		boolean checking = rs.next();
		close(rs, ps, connect);
		
		return checking;
		
	}
	
	// 이미 책이 2권 대여되어 있는지 체크!
	public int checkBookRentCnt(int bookNo) throws SQLException {
		Connection connect = connect();
		String query = "SELECT count(book_no) AS cnt FROM rent WHERE book_no = ? GROUP BY book_no";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int count = rs.getInt("cnt");
			close(rs, ps, connect);
			return count;
		}
		close(rs, ps, connect);
		return 0;
	}

	
	
	
	
	// 8. 내가 대여한 책 조회
	public ArrayList<Book> printRentBook(String id) throws SQLException {
		ArrayList<Book> list = new ArrayList<Book>();
		Connection connect = connect();
		String query = "SELECT b.book_no, title, author, access_age FROM rent r "
						+ "JOIN book b ON r.book_no = b.book_no "
						+ "WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			list.add(new Book(rs.getInt("b.book_no"),rs.getString("title"),rs.getString("author"),rs.getInt("access_age")));
		}
		close(rs, ps, connect);
		return list;
	}
	
	// 9. 대여 취소
	public void deleteRent(String id, int bookNo) throws SQLException {
		Connection connect = connect();
		String query = "DELETE FROM rent WHERE id = ? and book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		ps.executeUpdate();
		close(ps, connect);
		return;
		
	}
	
	
	
	
	
}
