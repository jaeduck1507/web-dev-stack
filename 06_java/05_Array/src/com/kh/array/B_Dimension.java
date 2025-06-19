package com.kh.array;

import java.util.Arrays;

public class B_Dimension {
	
	/*
	 * 다차원 배열 : '[]'의 개수가 차원의 수를 의미
	 * 
	 * * 2차원 배열의 선언
	 * 자료형[][] 배열명;
	 * 자료형 배열명 [][];
	 * 자료형[] 배열명[];
	 * 
	 * * 2차원 배열의 생성
	 * 
	 * 배열명 = new 자료형[][];
	 * */
	
	public void method1() {
		int[][] arr = {
				{1,2,3,4,5},
				{6,7,8,9,10}
		};
		
		/*
		 * [1,2,3,4,5]
		 * [6,7,8,9,10]
		 * */
		
		for(int[] i : arr) {
			System.out.println(Arrays.toString(i));
		}
		
		/*
		 * 1
		 * 2
		 * 3
		 * ..
		 * 8
		 * 9
		 * 10
		 * 
		 * */
		
		for(int[] i : arr) {
			for(int k : i) {
				System.out.println(k); 
			}
		}
		
		
	}
	// 가변 배열: 다차원 배열에서 마지막 차수의 크기를 지정하지 않고 다르게 지정
	/*
	 * [HTML,CSS,JavaScript,Oracle,MySQL]
	 * [Java, JDBC, Servlet, JSP, MyBatis, SpringBoot]
	 * [React, Redux, React Query]
	 * [SpringBoot API, JPA, QueryDSL]
	 * [AWS, EC2, S3, RDS, Render, Netlify]
	 * */
	public void method2() {
		String[][] arr = {
				{"HTML", "CSS", "JavaScript", "Oracle", "MySQL"},
				{"Java", "Kotlin" ,"JDBC", "Servlet", "JSP", "MyBatis", "SpringBoot"},
				{"React", "Redux", "React Query","TypeScript","Vue","React Native"},
				{"SpringBoot API", "JPA", "QueryDSL"},
				{"Node","Express","Nest"},
				{"AWS", "EC2", "S3", "RDS", "Render", "Netlify"}
		};
		
		for(String[] i : arr) {
			System.out.println(Arrays.toString(i));
		}
		
		
		
	}
	
	public static void main(String[] args) {
		B_Dimension b = new B_Dimension();
//		b.method1();
		b.method2();
	}

}
