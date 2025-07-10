package view;

import controller.testController;
import vo.EmployeeInfo;

public class Test {
	
	testController tc = new testController();
	
	public static void main(String[] args) {
		Test t = new Test();
		t.test1();
		
	}
	
	public void test1() {
		for(EmployeeInfo e : tc.test1()) {
			System.out.println(e);
		}
	}

}
