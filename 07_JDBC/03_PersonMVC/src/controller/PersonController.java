package controller;

import java.sql.*;
import java.util.ArrayList;

import config.ServerInfo;
import model.Person;

public class PersonController {

	// 리턴 타입이나 파라미터 자유롭게 변경 가능
	// 메서드도 추가 가능!

	public PersonController() {
		try {
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 변동적인 반복 : DAO(Database Access Object)
	public Connection getConnect() throws SQLException {
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

	public boolean allSame(Connection connect, String name, int age, String addr) throws SQLException {
		// 이름 나이 주소 모두 중복인지 검사하는 메소드
		PreparedStatement ps = connect.prepareStatement("SELECT * FROM person WHERE name =? and age =? and addr =?");
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			close(rs, ps, connect);
			return true;
		}
		
		rs.close();
		ps.close();
		return false;
	}

	// person 테이블에 데이터 추가 - INSERT
	public String addPerson(String name, int age, String addr) throws SQLException {

		Connection connect = getConnect();

		// 이름 나이 주소 모두 중복시 추가 제외!!
		if (allSame(connect, name, age, addr)) {

			return "이미 중복된 정보가 있습니다.";
		}

		PreparedStatement ps = connect.prepareStatement("INSERT INTO person(name, age, addr) VALUES(?,?,?)");
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		
		if (ps.executeUpdate() > 0) {
			close(ps, connect);
			return String.format("%s님의 정보가 성공적으로 등록되었습니다!!", name);
		}
		
		close(ps, connect);
		return "실패하였습니다!";

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<Person> searchAllPerson() throws SQLException {
		ArrayList<Person> list = new ArrayList<Person>();

		Connection connect = getConnect();
		PreparedStatement ps = connect.prepareStatement("SELECT * FROM person");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			list.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
			// System.out.println(list);
		}
//			System.out.println(list);
		close(rs, ps, connect);
		return list;

	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> 아이디로!
	public Person searchPerson(int n) throws SQLException {
		Person p = null;

		Connection connect = getConnect();
		PreparedStatement ps = connect.prepareStatement("SELECT * FROM person WHERE id = ?");
		ps.setInt(1, n);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			p = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
		
		close(rs, ps, connect);
		return p;

	}

	// person 테이블에 데이터 수정 - UPDATE
	public String updatePerson(int n, String name, int age, String addr) throws SQLException {

		Connection connect = getConnect();
		if (allSame(connect, name, age, addr)) {

			return "이미 중복된 정보가 있습니다.";
		}

		PreparedStatement ps = connect.prepareStatement("UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?");
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		ps.setInt(4, n);
		if (ps.executeUpdate() > 0) {
			close(ps, connect);
			return "성공적으로 수정되었습니다!!";
			
		}
		close(ps, connect);
		return "수정 실패";

	}

	// person 테이블에 데이터 삭제 - DELETE

	public String removePerson(int n) throws SQLException {

		Connection connect = getConnect();
		PreparedStatement ps = connect.prepareStatement("DELETE FROM person WHERE id = ?");
		ps.setInt(1, n);
		if (ps.executeUpdate() > 0) {
			close(ps,connect);
			return "성공적으로 삭제되었습니다!!";
		}
		close(ps,connect);
		return "삭제 실패";
	}

}
