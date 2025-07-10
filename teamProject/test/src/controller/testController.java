package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.EmployeeDAO;
import vo.EmployeeInfo;

public class testController {
	private EmployeeDAO eDao = EmployeeDAO.getInstance();
	
	public ArrayList<EmployeeInfo> test1() {
		ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
		try {
			list = eDao.allEmp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
