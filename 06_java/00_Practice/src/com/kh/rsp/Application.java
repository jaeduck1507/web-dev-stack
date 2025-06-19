package com.kh.rsp;

import com.kh.rsp.controller.RspController;
import com.kh.rsp.model.RspModel;
import com.kh.rsp.view.RspView;

public class Application {
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
	public static void main(String[] args) {
		RspModel rspModel = new RspModel();
		RspView rspView = new RspView();
		RspController rspController = new RspController(rspModel, rspView);
		
		rspController.rspPlay();
	}

}
