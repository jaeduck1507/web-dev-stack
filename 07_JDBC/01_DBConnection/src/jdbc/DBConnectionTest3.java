package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import config.ServerInfo;

public class DBConnectionTest3 {

	
	public static void main(String[] args) {
		
		
		// 1. 드라이버 로딩
		// 2. 디비 연결
		// 3. PreparedStatement - 쿼리 : UPDATE (user_no 선택 email 수정)
		// 4. 쿼리문 실행 - executeUpdate
		
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("드라이브 로딩");
			
			Connection connect = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
			
			String query = "UPDATE user_info SET email = ? WHERE user_no = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, "eee");
			ps.setInt(2, 1);
			
			
			
//			ps.executeUpdate();
			
			System.out.println(ps.executeUpdate() + "명 수정 완료!!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
