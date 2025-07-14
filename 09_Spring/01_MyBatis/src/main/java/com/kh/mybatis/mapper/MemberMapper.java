package com.kh.mybatis.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.vo.Member;

@Mapper
public interface MemberMapper {
	void register(Member member);
	Member login(Member member);
	List<Member> allMember();
	void update(Member member);
}
