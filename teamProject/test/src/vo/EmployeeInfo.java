package vo;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class EmployeeInfo {
	private int empNo;
	private String empId;
	private String empIn;
	private String empPwd;
	private String empName;
	private String gender;
	private Date birthdate;
	private int jobNo;
	private int deptNo;
	private Date hireDate;
	private Date quitDate;
	private double salary;
	private String addr;
	private String phone;
	private String email;
	
}
