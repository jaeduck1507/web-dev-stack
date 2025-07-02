package transaction;

import java.sql.*;

import config.ServerInfo;

public class TransactionTest2 {
	
	/*
	 * 지은 -> 지연 : 3만원씩 이체
	 * 지은님의 잔액이 마이너스가 될 경우 이체 취소
	 * */
	
	public static void main(String[] args) {
		try {
			Class.forName(ServerInfo.DRIVER);
			
			Connection connect = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
			
			
			connect.setAutoCommit(false);
			
			
			String query1 = "UPDATE bank SET balance = balance - ? WHERE name =?";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			
			ps1.setInt(1, 30000);
			ps1.setString(2, "지은");
			ps1.executeUpdate();

			
			String query2 = "UPDATE bank SET balance = balance + ? WHERE name =?";
			PreparedStatement ps2 = connect.prepareStatement(query2);
			
			ps2.setInt(1, 30000);
			ps2.setString(2, "지연");
			ps2.executeUpdate();
			
			String query = "SELECT * FROM bank WHERE name = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, "지은");
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getInt("balance") < 0) {
				connect.rollback();
				System.out.println("잔액이 부족합니다");
			} else {
				connect.commit();
				System.out.println("이체 완료");
			}
			
			connect.setAutoCommit(true);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
