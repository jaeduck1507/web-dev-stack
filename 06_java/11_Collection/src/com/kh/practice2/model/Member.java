package com.kh.practice2.model;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Member {
	private String name;
	private int age;
	private int coupon;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public Member(String name,int age) {
		this.name = name;
		this.age = age;
	}
}
