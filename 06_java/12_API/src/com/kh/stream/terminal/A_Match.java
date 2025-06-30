package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;

import com.kh.stream.model.Student;

/*
 * 매칭
 * - 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사하는 역할
 * - allMatch : 모든 요소들이 매개 값으로 주어진 조건을 만족하는지 조사
 * - anyMatch :
 * - nonMatch
 * */
public class A_Match {
	
	List<Student> students = Arrays.asList(
			new Student("오재덕",20,"남자",80,90),
			new Student("이승민",19,"남자",75,80),
			new Student("이환희",18,"여자",50,100),
			new Student("박기민",17,"남자",70,90),
			new Student("조규상",18,"남자",75,85),
			new Student("이상엽",20,"남자",100,60),
			new Student("성예찬",19,"남자",70,95)
			);
	
	public void method1() {
		int[] values = {2,4,6};
		boolean result = Arrays.stream(values).allMatch(value -> value % 2 == 0);
		System.out.println(result);
		result = Arrays.stream(values).anyMatch(value -> value %3 == 0);
		System.out.println(result);
		result = Arrays.stream(values).noneMatch(value -> value % 5 == 0);
		System.out.println(result);
		
	}
	public void method2() {
		// 나이가 18살 이하인 학생들이 모두 남자인지 확인
		boolean result1 = 
				students.stream()
					.filter(student -> student.getAge() <= 18)
					.allMatch(student -> student.getGender().equals("남자"));
		System.out.println("나이가 18살 이하인 학생들이 모두 남자인지? " + result1);
		
		// 남학생들 중에 평균이 90점 이상이 한명이라도 존재하는지 확인
		boolean result2 =
				students.stream()
					.filter(student -> student.getGender().equals("남자"))
					.anyMatch(student -> (double)(student.getMath() + student.getEnglish()) /2 >= 90);
		
		System.out.println("남학생들 중에 평균이 90점 이상이 한명이라도 존재하는지? " + result2);
	}
	
	
	public static void main(String[] args) {
		A_Match a = new A_Match();
//		a.method1();
		a.method2();
	}

}
