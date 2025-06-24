package com.kh._abstract.step2;

public class PotatoPizza extends Pizza {
	
	public PotatoPizza(int price, String brand) {
		super(price, brand);
		
	}

	public void pizzaInfo() {
		System.out.printf("%s의 불고기 피자 가격은 %d원\n", this.brand,this.price);
	}

	@Override
	public void addTopping() {
		System.out.println("토핑은 포테이토가 포함된다.");
	}


	@Override
	public void cook() {
		System.out.println("200~220℃에서 15~18분간 감자가 익고 치즈와 가장자리가 노릇해질 때까지 구운다.");
	}






}
