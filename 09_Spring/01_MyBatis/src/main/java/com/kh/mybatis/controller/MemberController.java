package com.kh.mybatis.controller;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("list", service.allMember());
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}
	
	@PostMapping("/register")
	public String register(Member member) {
		service.register(member);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpServletRequest request) {
		Member m = service.login(member);
		HttpSession session = request.getSession();
		session.setAttribute("member", m);
		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam String name,@RequestParam String pwd,@RequestParam String age , HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member sessionMember = (Member) session.getAttribute("member");
		
		name = name.isBlank() ? sessionMember.getName() :name;
		pwd = pwd.isBlank() ? sessionMember.getPwd() :pwd;
		int ageNum = sessionMember.getAge();
		try {
			ageNum = Integer.parseInt(age);
			if(ageNum <= 0) ageNum = sessionMember.getAge();
		} catch(Exception e) {
		}
		
		Member updateM = new Member(sessionMember.getId(),pwd,name,ageNum);
		service.update(updateM);
		session.setAttribute("member", updateM);
		return "redirect:/";
	}
	

	
}
