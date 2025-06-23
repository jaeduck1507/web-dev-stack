package com.kh.overriding.controller;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VipCustomer;

public class Controller {
	public int a;
	
	public String pay(Customer c, int cost) {
		return String.format("%s님의 등급은 %s이며, 지불해야하는 금액은 %d원이며, 적립된 포인트는 %.2f점입니다.", c.getName(),c.getGrade(),cost,cost*c.getBonusRatio());
	}
	
	public String pay(VipCustomer v, int cost) {
		return String.format("%s님의 등급은 %s이며, 지불해야하는 금액은 %d원이며, 적립된 포인트는 %.2f점입니다.", v.getName(),v.getGrade(),(int)(cost * (1-v.getSaleRatio())),cost*v.getBonusRatio());
	}
	
	
}
