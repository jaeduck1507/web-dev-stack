package com.kh.ajax.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.ajax.model.vo.Member;

@Mapper
public interface AjaxMapper {
	
	Member check(String id);
	boolean idBoolCheck(String id);
	void register(Member vo);
}
