package com.kh.overriding.model;

public class VipCustomer extends Customer{
	private double saleRatio; // 할인율
	
	
	
	public VipCustomer() {
	}



	public VipCustomer(String name) {
		this.name = name;
		this.grade = "VIP";
		this.bonusRatio = 0.1;
		this.saleRatio = 0.5;
	}

	
	
	public double getSaleRatio() {
		return saleRatio;
	}



	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}



	@Override
	public String toString() {
		return String.format("%s님의 등급은 %s이며, 지불해야하는 금액은 %d원이며, 적립된 포인트는 %.2f점입니다.", name,grade,(int)(100000 * (1-saleRatio)),100000*bonusRatio);
	}
	
	
	/*
	 * 오버라이딩의 조건
	 * - 부모 클래스의 메서드명, 매개변수, 리턴타입 모두 동일
	 * - 접근제어자를 좁은 범위로 변경할 수 없다.
	 * 		- 부모 클래스가 protected라면 범위가 같거나 넓은 protected나 public으로만 변경 가능
	 * */
	
	/*
	 * @Override 어노테이션
	 * - 명시 안 해줘도 오버라이딩
	 * - 어노테이션을 붙이는 이유
	 * 	- 해당 메서드가 오버라이딩 된 메서드라는 것을 컴파일러에게 알려주는 역할
	 *  - 자식 메서드에서 재정의를 잘못한 경우 컴파일 에러 표시
	 * */
	
	@Override
	public void calc(int price) {
		this.bonusPoint = (int)(price * bonusRatio);
		this.price = (int)(price * ((1-saleRatio)));
	}
	
	
	
}
