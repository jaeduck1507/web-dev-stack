package com.kh._abstract.step2;

public abstract class Pizza  {
	
	protected int price;
	protected String brand;
	
	public Pizza(int price, String brand) {
		this.price = price;
		this.brand = brand;
	}
	
	// 여기서부터는 자유롭게!
	
	public abstract void pizzaInfo();
	
	public void preparation() {
		System.out.println("피자 반죽과 함께 도우를 빚는다.");
	}
	
	public abstract void addTopping();

	
	public abstract void cook();
	
	public void dividePizza() {
		System.out.println("피자를 8등분한다.");
	}
	
	public void packPizza() {
		System.out.println("피자를 포장한다.");
	}
}
