package com.kh.step5;

public class User1 extends Thread{
	
	Calculator cal;
	
	
	public void setCal(Calculator cal) {
		setName("Calculator User 1");
		this.cal = cal;
	}



	public void run() {
		this.cal.setMemory(100);
	}
}
