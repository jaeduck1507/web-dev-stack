package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.AjaxService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AjaxController {
	
	private int count = 0;
	
	@Autowired
	private AjaxService service;
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax요청!!");
		
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(@RequestParam(name = "nickname", required = false, defaultValue = "ㅎㅇ") String nickname) {
		
		System.out.println(nickname);
		return nickname;
	}
	
	@ResponseBody
	@PostMapping("/check")
	public boolean check(@RequestParam(name = "id")String id) {
		System.out.println(service.idBoolCheck(id));
		Member member = service.check(id);
		return member ==null ;
	}
	
	@ResponseBody
	@PostMapping("/signup")
	public Member signup(Member vo) {
		service.register(vo);
		return vo;
	}
	
	@ResponseBody
	@PostMapping("/register")
	public Member register(Member vo) {
		service.register(vo);
		return vo;
	}
}
