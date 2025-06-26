package com.kh.set;

import java.util.*;

import com.kh.list.model.Person;

public class A_HashSet {
	
	/*
	 * Set 특징
	 * - 중복 제거
	 * - 순서 없음
	 * 
	 * */
	
	public void method1() {
		HashSet<String> set = new HashSet<String>();
		set.add("전현무");
		set.add("박나래");
		set.add("기안84");
		set.add("키");
		set.add("박나래"); // 여러 번 추가해도 중복 제거!

		System.out.println(set);
		System.out.println("몇 명이 들어있나요? " + set.size());
		System.out.println("기안84가 포함되어있나요? " + set.contains("기안84"));
		
		
		
		set.remove("박나래"); // 삭제
		System.out.println(set);
		
		set.clear(); // 전체 삭제
		System.out.println("비어있는가? " + set.isEmpty());
		
	}
	
	public void method2() {
		HashSet<Person> set = new HashSet<Person>();
		set.add(new Person("전현무", "삼성동", 47));
		set.add(new Person("박나래", "이태원동", 39));
		set.add(new Person("기안84", "과천시", 40));
		set.add(new Person("키", "한남동", 33));
		set.add(new Person("키", "한남동", 33));
		
		for(Person p : set) {
			System.out.println(p.toString());
		}
		
		System.out.println(set);
		
		/*
		 * Iterator
		 * - 컬렉션에 저장된 요소를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 * */
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
	public static void main(String[] args) {
		A_HashSet a = new A_HashSet();
//		a.method1();
		a.method2();
	}

}
