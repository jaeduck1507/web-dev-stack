package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ajax.mapper.AjaxMapper;
import com.kh.ajax.model.vo.Member;

@Service
public class AjaxService {
	
	@Autowired private AjaxMapper mapper;
	
	public Member check(String id) {
		
		return mapper.check(id);
	}
	
	public boolean idBoolCheck(String id) {
		return mapper.idBoolCheck(id);
	}
	
	public void register(Member vo) {
		mapper.register(vo);
	}
}
