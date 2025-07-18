package com.kh.mybatis.service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.mybatis.controller.MemberController;
import com.kh.mybatis.mapper.MemberMapper;
import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	public void register(Member member) {
		mapper.register(member);
	}
	
	public Member login(Member member) {
		Member m =  mapper.login(member);
//		System.out.println(m);
		return m;
	}
	
	public List<Member> allMember() {
		return mapper.allMember();
	}
	
	public void update(Member member) {
		mapper.update(member);
	}
	
	public void delete(Member member) {
		mapper.delete(member);
	}
	
	public List<Member> search(SearchDTO dto) {
		List<Member> list = mapper.search(dto);
		return list;
	}
	
	public void selectDelete(List<String> idList) {
		mapper.selectDelete(idList);
	}
}
