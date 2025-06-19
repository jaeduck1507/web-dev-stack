package com.kh.rsp.model;



public class RspModel {
	
	
	
	public String[] rspArr = {"가위","바위","보"};
	public String[][] wdlArr = {{"draw","lose","win"},{"win","draw","lose"},{"lose","win","draw"}};
	public int win,draw,lose,userRspIndex;
	public String user;
	public String userRSP;
	public boolean flag = true;
	

}
