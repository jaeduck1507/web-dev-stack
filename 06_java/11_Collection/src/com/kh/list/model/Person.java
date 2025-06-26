package com.kh.list.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode 
public class Person implements Comparable<Person>{
	
	private String name;
	private String addr;
	private int age;
	
	/*
	 * compareTO : 반환된 값을 가지고 정렬 기준 잡아주는 메서드
	 * - 자기자신과 파라미터값으로 전달된 객체가 같은 타입의 객체인지 비교
	 * - 비교해서 같으면 0, 자기자신이 크다면 양의 정수(1) 작다면 음의정수 -1 반환
	 * */
	@Override
	public int compareTo(Person o) {
//		return this.age == o.age ? 0 : this.age > o.age ? 1 : -1;
		return this.name.compareTo(o.name);
	}
	
}
