package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		// 1. 드라이브 로딩
		// 2. 디비 연결
		// 3. PreparedStatement - delete (user_no)
		// 4. 쿼리문 실행
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			Class.forName(p.getProperty("driver"));
			System.out.println("드라이브 로딩!");
			
			Connection connect = DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
			System.out.println("디비 연결");
			
			PreparedStatement ps = connect.prepareStatement("DELETE FROM USER_INFO WHERE user_no = ?");
			ps.setInt(1, 2);
			System.out.println(ps.executeUpdate() + "명 삭제 완료");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
