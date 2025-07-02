package jdbc;

import java.sql.*;

public class DBConnectionTest2 {

	public static void main(String[] args) {
		// 1. 드라이버 로딩
		
		// 2. 데이터베이스 연결
		
		// 3. PreparedStatement 객체 생성 - Insert - user_info 테이블 사람 한명 추가 쿼리문 작성
		
		// 4. 쿼리문 실행 - rs.executeUpdate()
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이브 로딩");
			
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","qwer1234");
			
			String query = "INSERT INTO user_info(id, password,name) VALUES(?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, "user03");
			ps.setString(2, "2222");
			ps.setString(3, "김미경");
			
			
//			ps.executeUpdate();
			
			System.out.println(ps.executeUpdate() + "명 추가 완료!! 삽입완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
