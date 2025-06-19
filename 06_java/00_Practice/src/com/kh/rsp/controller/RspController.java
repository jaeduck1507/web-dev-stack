package com.kh.rsp.controller;

import java.util.Random;

import com.kh.rsp.model.RspModel;
import com.kh.rsp.view.RspView;

public class RspController {
	Random r = new Random();
	public RspModel rspModel;
	public RspView rspView;
	
	public RspController(RspModel rspModel,RspView rspView) {
		this.rspModel = rspModel;
		this.rspView = rspView;
	}
	
	public void rspPlay() {
		rspModel.user = rspView.getUserName();
		while(rspModel.flag) {
			if(userRsp()) continue;
			rspJudgment(rspModel.userRspIndex);
		}
	}
	
	public boolean userRsp() {
		switch(rspView.getUserRsp()) {
		case "가위":
			rspModel.userRspIndex = 0;
    		break;
    	case "바위":
    		rspModel.userRspIndex = 1;
    		break;
    	case "보":
    		rspModel.userRspIndex = 2;
    		break;
    	default:
    		System.out.println("잘못 입력");
    		return true;
		}
		return false;
	}
	
	public void rspJudgment(int index) {
		int random = r.nextInt(3);
		rspView.status(rspModel.user, rspModel.rspArr[index], rspModel.rspArr[random]);
		switch(rspModel.wdlArr[index][random]) {
    	case "lose":
    		rspView.wdlShow("졌습니다 ㅠㅠ");
    		rspModel.lose++;
    		break;
    	case "draw":
    		rspView.wdlShow("비겼습니다");
    		rspModel.draw++;
    		break;
    	case "win":
    		rspView.wdlShow("이겼습니다 !");    		
    		rspModel.win++;
    		rspModel.flag = false;
    		rspView.rspResult(rspModel.draw, rspModel.lose, rspModel.win);
    		break;
    	default:
    	}
	}
}
