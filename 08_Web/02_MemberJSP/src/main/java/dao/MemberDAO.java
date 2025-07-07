package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection connection() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps,connect);
	}
	
	public void close( PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}
	
	public void register(Member member) throws SQLException {
		Connection connect = connection();
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		ps.executeUpdate();
		System.out.println("삽입완료");
		close(ps, connect);
		
	}
}
