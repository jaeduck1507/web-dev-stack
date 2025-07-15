package com.kh.mybatis.controller;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
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
		
		//List<Member> list = (List<Member>) model.getAttribute("searchList");
		//System.out.println(list);
		model.addAttribute("list", service.allMember());
		//if(list == null) model.addAttribute("list", service.allMember());
		//else if(list.size() == 0) model.addAttribute("list", service.allMember());
		//else model.addAttribute("list", list);
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
	
//	@PostMapping("/update")
//	public String update(@RequestParam  String name,@RequestParam String pwd,@RequestParam String age , HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Member sessionMember = (Member) session.getAttribute("member");
//		
//		name = name.isBlank() ? sessionMember.getName() :name;
//		pwd = pwd.isBlank() ? sessionMember.getPwd() :pwd;
//		int ageNum = sessionMember.getAge();
//		try {
//			ageNum = Integer.parseInt(age);
//			if(ageNum <= 0) ageNum = sessionMember.getAge();
//		} catch(Exception e) {
//		}
//		
//		Member updateM = new Member(sessionMember.getId(),pwd,name,ageNum);
//		service.update(updateM);
//		session.setAttribute("member", updateM);
//		return "redirect:/";
//	}
	
	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		vo.setId(member.getId());
		service.update(vo);
		
		Member result = service.login(vo);
		session.setAttribute("member", result);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		service.delete((Member) session.getAttribute("member"));
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String search(SearchDTO dto, Model model) {
		
		model.addAttribute("list", service.search(dto));
		return "index";
	}
	

	
}
