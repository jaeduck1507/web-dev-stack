package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza {
	
	
	
	public BulgogiPizza(int price, String brand) {
		super(price, brand);
		
	}

	public void pizzaInfo() {
		System.out.printf("%s의 불고기 피자 가격은 %d원\n", this.brand,this.price);
	}

	@Override
	public void addTopping() {
		System.out.println("토핑은 불고기가 포함된다.");
	}


	@Override
	public void cook() {
		System.out.println("200~220℃에서 10~15분간 치즈가 녹고 가장자리가 노릇해질 때까지 구운다.");
	}






}
