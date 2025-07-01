package com.kh.step5;

public class Application {

	public static void main(String[] args) {
		
		// 스레드들은 공유 자원을 서로 공유한다
		
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		User2 user2 = new User2();
		user1.setCal(cal);
		user2.setCal(cal);
	
		user1.start();
		user2.start();
		
//		user1.run();
//		user2.run();
		
		
	}
}

