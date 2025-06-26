package com.kh.practice2.controller;

import com.kh.practice2.model.*;
import java.util.*;

public class BookController {
	private List<Member> memberList = new ArrayList<Member>();
	private Member member = new Member();
	private ArrayList<Book> books = new ArrayList<>();
	private int count;
	
	
	public void addBook() {
		books.add(new Book("디스 이즈 이탈리아", false, 0, 3));
        books.add(new Book("리얼 런던", true, 0, 3));
        books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0, 3));
        books.add(new Book("사퀴트리 샌드위치", false, 0, 3));
        books.add(new Book("원피스 111", true, 15, 3));
        books.add(new Book("귀멸의 칼날 23", false, 19, 3));
        books.add(new Book("진격의 거인 Before the fall 16", false, 19, 3));
	}
	
	
	public boolean checkLogin(String name, int age) {
		if(memberList == null) {
			Member member = new Member(name,age);
			memberList.add(member);
			this.member = member;
			return true;
		}
		for(count = 0; count < memberList.size(); count++) {
			
			if(memberList.get(count).getName().equals(name)) {
				if(memberList.get(count).getAge() == age) {
					this.member = memberList.get(count);
					return true;
				}
				else return false;
			}
		}
		Member member = new Member(name,age);
		memberList.add(member);
		this.member = member;
		return true;
	}
	
	
	public String showInfo() {
		return member.toString();
	}
	
	
	
	
	public int bookRental(int n) {
		n--;
		if (books.get(n).getBookConut() == 0) return 4;
		if (member.getBookList().size() >= 3) return 1;
		if (member.getBookList().contains(books.get(n))) return 2;
		if (books.get(n).getAccessAge() > member.getAge() && member.getCoupon() == 0) return 3;
		if (books.get(n).getAccessAge() > member.getAge() &&member.getCoupon() > 0) {
			member.setCoupon(member.getCoupon()-1);
		}
		
		member.getBookList().add(books.get(n));
		if(books.get(n).isCoupon()) member.setCoupon(member.getCoupon()+1);
		books.get(n).setBookConut(books.get(n).getBookConut() - 1);
		memberList.set(count, this.member);
		
		return 0;
	}
	
	

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public ArrayList<Book> getBooks() {
		return books;
	}


	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	
}
