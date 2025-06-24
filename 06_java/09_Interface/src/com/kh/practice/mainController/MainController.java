package com.kh.practice.mainController;

import java.time.LocalDate;

import com.kh.practice.model.*;

public class MainController {
	private UserInfo u = new UserInfo();

	public void addUser(int userNo, String id, String password, String email, String name) { // 일반적인 입력시 생성자
		u = new UserInfo(userNo, id, password, email, name); 
	}
	
	public void addUser(int userNo, String id, String password, String email, String name, String phone,String addr, String gender,
			LocalDate birthDate, Department department) { // 추가 정보 입력시 생성자
		u = new UserInfo(userNo, id, password, email, name, phone,addr ,gender, birthDate, department);
	}
	
	public Department setDept(int deptNo) { // 부서 번호 등록에 따라 부서이름 할당 - 없는 번호 입력시 부서 "부서 미정"
		String deptName = "";
		switch(deptNo) {
		case 1:
			deptName = "개발";
			break;
		case 2:
			deptName = "지원";
			break;
		case 3:
			deptName = "인사";
			break;
		default:
			deptName = "부서 미정";
			deptNo = 0;
			break;
		}
		
		
		return new Department(deptNo,deptName);
	}
	
	
	public boolean checkInfo(String id,String password) { // 아이디 패스워드 일치 여부 확인			
		return u.getId().equals(id) && u.getPassword().equals(password);
	}
	
	
	
	public UserInfo getU() {
		return u;
	}

	public void setU(UserInfo u) {
		this.u = u;
	}
	
	
	
}
