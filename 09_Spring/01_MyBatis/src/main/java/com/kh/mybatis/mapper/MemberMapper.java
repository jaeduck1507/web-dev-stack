package com.kh.mybatis.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

@Mapper
public interface MemberMapper {
	void register(Member member);
	Member login(Member member);
	List<Member> allMember();
	void update(Member member);
	void delete(Member member);
	List<Member> search(SearchDTO dto);
}
