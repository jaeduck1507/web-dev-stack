package com.kh._abstract.step2;

public class PineapplePizza extends Pizza {
	
	public PineapplePizza(int price, String brand) {
		super(price, brand);
		
	}

	public void pizzaInfo() {
		System.out.printf("%s의 불고기 피자 가격은 %d원\n", this.brand,this.price);
	}

	@Override
	public void addTopping() {
		System.out.println("토핑은 파인애플이 포함된다.");
	}


	@Override
	public void cook() {
		System.out.println("200~220℃에서 12~15분간 치즈가 녹고 파인애플이 살짝 캐러멜라이즈될 때까지 구운다.");
	}






}
