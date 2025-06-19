package com.kh.rsp.view;

import java.util.Scanner;

public class RspView {
	Scanner sc = new Scanner(System.in);
	
	public String getUserName() {
		System.out.print("당신의 이름을 입력해주세요 : ");
    	String user = sc.nextLine();
		
		return user;	
		}
	
	public String getUserRsp() {
		System.out.print("가위바위보 : ");
    	String userRsp = sc.nextLine();
    	return userRsp;
	}
	public void status(String user,String userRsp, String comRsp) {
		System.out.println(user + " : " + userRsp);
    	System.out.println("컴퓨터 : " + comRsp);
	}
	
	public void wdlShow(String wdl) {
		System.out.println(wdl);
	}
	public void rspResult(int draw,int lose,int win) {
		System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d\n",draw,lose,win); 
	}
	
}
