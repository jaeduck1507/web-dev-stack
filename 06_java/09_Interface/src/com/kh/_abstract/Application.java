package com.kh._abstract;

import com.kh._abstract.step1.*;
import com.kh._abstract.step2.*;

public class Application {
	
	/*
	 * 추상클래스(Abstract Class)
	 * - 미완성 클래스로 추상 메서드를 포함한 클래스
	 * - 미완성 클래스이기 때문에 new 연산자를 통해서 객체 생성 X
	 * - 일반적인 필드, 메서드 포함 (변수 + 메서드 + 추상 메서드)
	 * - 객체 생성 할 수 없지만 참조형 변수 타입으로 사용 가능
	 * - 상속 관계로 다형성 적용 가능
	 * 
	 * 추상메서드(Abstract Method)
	 * - 미완성 메서드로 중괄호({})가 구현되지 않는 메서드
	 * - 추상 클래스를 상속받는 자식 클래스에서 "반드시" 오버라이딩(재정의)
	 * - 오버라이딩 해주지 않으면 컴파일 에러
	 * - 자식 클래스에 강제성 부여
	 * */
	public static void main(String[] args) {
		// 추상 클래스여서 객체 생성 X
//		Sports s = new Sports(5);
		// 다형성으로 인해서 부모 타입으로 가능!
		Sports b = new BasketBall(9);
		Sports f = new FootBall(11);
		
//		b.rule();
//		f.rule();
		
		/*
		 * 브랜드, 가격 자유롭게, 저 세가지 피자는 다 사용!
		 * 
		 * 해당 브랜드의 불고기 피자 가격은 ~ 원
		 * 피자 반죽과 함께 도우를 빚는다.
		 * 토핑은 불고기 포함한다.
		 * 피자를 180도에서 10분간 구운다.
		 * 피자를 8등분한다.
		 * 피자를 포장한다.
		 * 
		 * 
		 * */
		
		Pizza[] pizzaArr = new Pizza[3];
		pizzaArr[0] = new BulgogiPizza(27000, "피자마루");
		pizzaArr[1] = new PotatoPizza(28000, "파파존스");
		pizzaArr[2] = new PineapplePizza(29000, "피자헛");
		
		for (Pizza p : pizzaArr) {
			System.out.println("-----------------------------------------------------------------");
			p.pizzaInfo();
			p.preparation();
			p.addTopping();
			p.cook();
			p.dividePizza();
			p.packPizza();
			System.out.println();
		}
		
	}

}
