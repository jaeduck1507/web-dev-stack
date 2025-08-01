package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.service.MemberService;
import com.kh.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(Member vo) {
		try {
			service.register(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login() {
	}
	
	@PostMapping("login")
	public String login(Member vo, HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			session.setAttribute("member", service.login(vo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@GetMapping("search")
	public void search() {
		
	}
	
	@GetMapping("find")
	public String search(@RequestParam("id") String id, Model model) {
		try {
			Member member = service.search(id);
			model.addAttribute("member",member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "result";
	}
	
	@GetMapping("allMember")
	public String allMember(Model model) {
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			list = service.allMember();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		return "allMember";
		
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
}
