package com.kh.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.list.model.Person;

public class A_ArrayList {
	
	/*
	 * - 컬렉션 : 자바에서 제공하는 자료구조를 담당하는 프레임워크
	 * - 자료구조 : 데이터를 효율적으로 이용하는 방법으로 데이터에 편리하게 접근하고, 효율적으로 사용하기 위해서 데이터를 저장하거나 조직하는 방법
	 * - java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들이 포함
	 * - 컬렉션을 사용하면 데이터 추가, 삭제, 정렬 등의 처리가 간단하게 해결되어 자류고조적 알고리즘을 구현할 필요가 없음
	 * 
	 * 컬렉션의 장점
	 * - 저장하는 크기의 제약이 없다.
	 * - 데이터의 추가, 삭제, 정렬 등의 기능처리가 간단하게 해결
	 * - 여러 타입의 데이터가 저장 가능 (제네릭 사용 - 같은 타입만 들어가도록)
	 * 
	 * List
	 * - 자료들을 순차적으로 늘어놓는 구조
	 * - 저장되는 객체를 인덱스로 관리하기 때문에 인덱스로 객체를 검색, 삭제할 수 있는 기능
	 * - 중복되는 객체 저장 가능하고, null 값도 저장 가능
	 * 
	 * List의 특징
	 * - 중복 허용
	 * - 순서 있음
	 * 
	 * ArrayList
	 * - 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어난다.
	 * - 동기화(Synchronized)를 제공하지 않는다.
	 * - 동기화 : 하나의 자원(데이터)에 대해 여러개의 스레드가 접근하려 할 때
	 * 		    한 시점에서 하나의 스레드만 사용할 수 있도록 하는 것을 말한다.
	 * */
	
	/*
	 * 제네릭(Generics)
	 * - 컴파일시 타입을 체크해 주는 기능
	 * - <> 다이아몬드 연산자 사용
	 * 
	 * 
	 * * 컬렉션에서 사용하는 이유
	 * -> 명시된 타입에 객체만 저장하도록 제한을 두기 위해
	 * */
	public void method1() {
		ArrayList<String> list = new ArrayList<>();
//		list.add(1);
		list.add("이승민");
		list.add(null);
//		list.add(true);
		
		
		
		System.out.println(list);
		
	}
	
	public void method2() {
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("전현무", "삼성동", 47));
		list.add(new Person("박나래", "이태원동", 39));
		// 인덱스를 지정하여 해당 인덱스에 추가
		// --> 내부적으로 기존에 있는 것들은 뒤로 밀리고 해당 인덱스에 추가
		
		list.add(1, new Person("기안84", "과천시", 40));
		
		// 2. set : 해당 인덱스의 값 변경
		list.set(0, new Person("키", "한남동", 33));
		
		// 3. size : 리스트 안에 몇개의 데이터가 있는지
		System.out.println("사람 수 : " + list.size());
		
		// 4. remove : 해당 인덱스의 객체 삭제
		list.remove(1);
		
		// 5. get : 해당 인덱스의 객체 가져오기
		System.out.println(list.get(0));
		
		// 6. subList : 기존 리스트에서 원하는 만큼 추출해서 새로운 리스트 반환
		list.add(new Person("전현무", "삼성동", 47));
		list.add(new Person("기안84", "과천시", 40));
		
		List<Person> subList = list.subList(0, 2);
		System.out.println(subList);
		
		// 7. addAll : 컬렉션을 통째로 추가
		list.addAll(subList);
		
		// 8. isEmpty : 컬렉션이 비어있는지
		System.out.println("리스트가 비어있는지? " + list.isEmpty());
		
		System.out.println(list);
		
	
		// 리스트에 저장된 평균 연령 출력
		// 저장된 사람들의 이름만 출력
		
		
		double sum = 0;
		
		for(Person p : list) {
			System.out.println(p.getName());
			sum += p.getAge();
		}
		
		System.out.println("평균 연령 : " + sum/list.size());
		
		// 나이 순서대로 정렬 - > 이름순으로 정렬
		Collections.sort(list);
		System.out.println(list);
		// 9. clear : 싹 비우기
		list.clear();
		
		
	}
	
	public void method3() {
		List<String> list = new ArrayList<String>();
		list.add("banana");
		list.add("orange");
		list.add("apple");
		list.add("mango");
		list.add("grape");
		
		System.out.println(list);

		// 10. 오름차순 정렬 : Comparable 인터페이스를 구현하고 있는 요소를 가지고 비교값들 반환하여 정렬
		Collections.sort(list);
		System.out.println(list);
		
		// 11. 내림차순 정렬 : sort 메서드로 오름차순 정렬 후 reverse로 정렬
		Collections.reverse(list);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		A_ArrayList a = new A_ArrayList();
//		a.method1();
		a.method2();
		a.method3();
		
		
		
	}

}
