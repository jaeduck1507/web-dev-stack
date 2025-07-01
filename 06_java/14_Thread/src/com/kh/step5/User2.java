package com.kh.step5;

public class User2 extends Thread{

	Calculator cal;
	
	

	



	public void setCal(Calculator cal) {
		setName("Calculator User 2");
		this.cal = cal;
	}

	
	public void run() {
		this.cal.setMemory(50);
	}
}
