package com.kh.practice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * NoArgsConstructor : 기본 생성자
 * AllArgsConstructor : 모든 필드를 매개변수로 받는 생성자
 *  Getter /Setter : 모든 필드의 Getter / Setter 메서드
 *  ToString : toString 메서드
 *  Data : Getter,Setter,ToString,EqualsAndHashCode, RequiredArgsConstructor
 * */
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter @Setter @ToString
public class UserInfo {
	private int userNo;
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String addr;
	private String gender;
	private LocalDate birthDate;
	private Department department;
	
	public UserInfo() {
	}

	public UserInfo(int userNo, String id, String password, String email, String name, String phone,String addr, String gender,
			LocalDate birthDate, Department department) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.gender = gender;
		this.birthDate = birthDate;
		this.department = department;
	}
	
	public UserInfo(int userNo, String id, String password, String email, String name) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format("직원 번호 : %d\n"
				+ "직원 아이디 : %s \n"
				+ "직원 비밀번호 : %s \n"
				+ "직원 이메일 : %s \n"
				+ "직원 이름 : %s \n"
				+ "직원 전화번호 : %s \n"
				+ "직원 주소 : %s \n"
				+ "직원 성별 : %s \n"
				+ "직원 생일 : " + (this.birthDate == null ? "." : this.birthDate)
				+ "\n부서 번호 : %d \n"
				+ "부서 이름 : %s \n",
				this.userNo, this.id, this.password, this.email,this.name,
				this.phone == null ? "." : this.phone,
				this.addr == null ? "." : this.addr,
				this.gender== null ? "." : this.gender,
				this.department == null? 0 : this.department.getDeptNo(),
				this.department == null ? "부서 미정" : this.department.getDeptName());
	}
	
	
	
}
