package com.kh.practice2.controller;

import com.kh.practice2.exception.DuplicateIdException;
import com.kh.practice2.exception.RecordNotFoundException;
import com.kh.practice2.model.Member;

public class MemberController {
	private Member[] arr = new Member[3];
	private int count;
	
	public void enroll(String id, String name, String pwd, String email, char gender, int age) {
		arr[count] = new Member(id, name, pwd, email, gender, age);
		
	}
	public void enroll(String id, String name, String pwd, String email, int count) {
		arr[count].setId(id);
		arr[count].setName(name);
		arr[count].setPwd(pwd);
		arr[count].setEmail(email);
	}
		
	
	public int idIsSame(String id) throws DuplicateIdException {
		for(int i = 0; i < arr.length; i++) {
			if ( arr[i] != null && arr[i].getId() != null) {
				if(arr[i].getId().equals(id)) {
					
					throw new DuplicateIdException();
					
				}
			}
		}
		return -1;
	}
	
	public int updateCheck(String id) throws RecordNotFoundException {
		
		for(int i = 0; i < arr.length; i++) {
			if ( arr[i] != null && arr[i].getId().equals(id)) {
				
					
					return i;
				
			}
		}
		throw new RecordNotFoundException();
	}
	
	public void checkEmpt() throws RecordNotFoundException {
		if(count == 0) throw new RecordNotFoundException();
	}
	
	public void countPlus() {
		count++;
	}
	
	public Member[] getArr() {
		return arr;
	}

	public void setArr(Member[] arr) {
		this.arr = arr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
