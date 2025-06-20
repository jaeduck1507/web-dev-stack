package com.kh.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.kh.practice.controller.RockPaperScissorController;
import com.kh.practice.model.RockPapterScissor;
import com.kh.practice.view.RockPaperScissorView;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
//		l.method6();
		l.method7();
		
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 : ");
    	int n = sc.nextInt();
    	sc.nextLine();
    	for(int i = n; i>0; i--) {
    		System.out.println(i);
    	}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	
    	int sum = 0;
    	int n = 1;
    	while(true) {
    		if(n % 2 == 0) sum -= n;
    		else sum += n;
    		
    		if(sum >= 100) break;
    		n++;
    	}
    	
    	System.out.println(n);
    	
    	
    	
    	
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	for(char i : str.toCharArray()) {
    		if(i == ch) count++;
    	}
    	System.out.printf("%s 안에 포함된 %s 개수 : %d\n",str,ch,count);
    	
    	
    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	Random r = new Random();
    	int random = 0;
    	while(true) {
    		random = r.nextInt(11);
//    		 random = (int)(Math.random()*11);
    		System.out.println(random);
    		if(random == 0) break;
    	}
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
		
		
		for(int i = 0; i < 10; i++) {
			switch((int)(Math.random()*6 + 1)) {
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			case 4:
				count4++;
				break;
			case 5:
				count5++;
				break;
			case 6:
				count6++;
				break;
			default:
			}
		}
		
		System.out.println("1 : " + count1);
		System.out.println("2 : " + count2);
		System.out.println("3 : " + count3);
		System.out.println("4 : " + count4);
		System.out.println("5 : " + count5);
		System.out.println("6 : " + count6);
		
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
//    public void method6() {
//    	Random r = new Random();
//    	int win = 0, draw = 0, lose = 0;
//    	boolean flag = true;
//       	int random = 0;
//    	String comRSP = "";
//    	String userRSP = "";
//    	
//    	System.out.print("당신의 이름을 입력해주세요 : ");
//    	String user = sc.nextLine();
//    	
//    	while(flag) {
//    		System.out.print("가위바위보 : ");
//        	userRSP = sc.nextLine();
//        	random = r.nextInt(1,4);
//        	
//        	
//        	switch(userRSP) { // 유저 가위바위보 내기
//        	case "가위":
//        		switch(random) { // 컴퓨터 가위바위보 내기
//            	case 1:
//            		comRSP = "가위";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("비겼습니다");
//            		draw++;
//            		break;
//            	case 2:
//            		comRSP = "바위";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("졌습니다 ㅠㅠ");
//            		lose++;
//            		break;
//            	case 3:
//            		comRSP = "보";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("이겼습니다 !");
//            		win++;
//            		flag = false;
//            		break;
//            	}
//        		break;
//        	case "바위":
//        		switch(random) { // 컴퓨터 가위바위보 내기
//            	case 1:
//            		comRSP = "가위";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("이겼습니다 !");
//            		win++;
//            		flag = false;
//            		break;
//            	case 2:
//            		comRSP = "바위";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("비겼습니다");
//            		draw++;
//            		break;
//            	case 3:
//            		comRSP = "보";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("졌습니다 ㅠㅠ");
//            		lose++;
//            		break;
//            	}
//        		break;
//        	case "보":
//        		switch(random) { // 컴퓨터 가위바위보 내기
//            	case 1:
//            		comRSP = "가위";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("졌습니다 ㅠㅠ");
//            		lose++;
//            		break;
//            	case 2:
//            		comRSP = "바위";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("이겼습니다 !");
//            		win++;
//            		flag = false;
//            		break;
//            	case 3:
//            		comRSP = "보";
//            		System.out.println("컴퓨터 : " + comRSP);
//            		System.out.println(user + " : " +userRSP);
//            		System.out.println("비겼습니다");
//            		draw++;
//            		break;
//            	}
//        		break;
//        	default:
//        		System.out.println("잘못 입력");
//        	}        	    		
//    	}
//    System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d\n",draw,lose,win); 
//    	
//    	
//    	
//    }
    
    public void method6() {
    	Random r = new Random(); 
    	String[] rsp = {"가위","바위","보"};
    	String[][] wdl = {{"draw","lose","win"},{"win","draw","lose"},{"lose","win","draw"}};
    	int win = 0, draw = 0, lose = 0;
    	boolean flag = true;
       	int random = 0;
    	int userRspIndex = 0;
    	
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String user = sc.nextLine();
    	
    	while(flag) {
    		System.out.print("가위바위보 : ");
        	String userRSP = sc.nextLine();
        	random = r.nextInt(3);
        	       	
        	switch(userRSP) { // 유저 가위바위보 내기
        	case "가위":
        		userRspIndex = 0;
        		break;
        	case "바위":
        		userRspIndex = 1;
        		break;
        	case "보":
        		userRspIndex = 2;
        		break;
        	default:
        		System.out.println("잘못 입력");
        		continue;
        	}
        	
        	System.out.println(user + " : " + userRSP);
        	System.out.println("컴퓨터 : " + rsp[random]);
        	switch(wdl[userRspIndex][random]) {
        	case "lose":
        		System.out.println("졌습니다 ㅠㅠ");
        		lose++;
        		break;
        	case "draw":
        		System.out.println("비겼습니다");
        		draw++;
        		break;
        	case "win":
        		System.out.println("이겼습니다 !");
        		win++;
        		flag = false;
        		break;
        	default:
        	}
        	
    	}
    System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d\n",draw,lose,win); 
    	
    	
    	
    }
    
    public void method7() {
    	
    	RockPaperScissorView rpsView = new RockPaperScissorView();
    	rpsView.gameStart();
    	
    }
}


