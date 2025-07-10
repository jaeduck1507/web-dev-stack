package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import config.ServerInfo;
import vo.EmployeeInfo;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	
	private EmployeeDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static EmployeeDAO getInstance() {
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
	
	// dao 기능 예시
	
	public ArrayList<EmployeeInfo> allEmp() throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM employee_info";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
		
		while(rs.next()) {
			EmployeeInfo emp = new EmployeeInfo();
			emp.setEmpNo(rs.getInt(1));
			emp.setEmpId(rs.getString(2));
			emp.setEmpIn(rs.getString(3));
			emp.setEmpPwd(rs.getString(4));
			emp.setEmpName(rs.getString(5));
			emp.setGender(rs.getString(6));
			emp.setBirthdate(rs.getDate(7));
			emp.setJobNo(rs.getInt(8));
			emp.setDeptNo(rs.getInt(9));
			emp.setHireDate(rs.getDate(10));
			emp.setQuitDate(rs.getDate(11));
			emp.setSalary(rs.getDouble(12));
			emp.setAddr(rs.getString(13));
			emp.setPhone(rs.getString(14));
			emp.setEmail(rs.getString(15));
			
			list.add(emp);
		}
		close(rs, ps, connect);
		
		return list;
	}
	
}
