package com.kh.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.security.model.vo.User;

@Controller
public class PageController {

	@GetMapping("/")
	public String index() {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(auth.toString().equals("anonymousUser"));
		if(auth.toString().equals("anonymousUser")) return "redirect:/login";
		//User user = (User) auth.getPrincipal();
		//System.out.println(user);
		return "index";
	}
	
	@GetMapping("/register") 
	public String register() {
		return "register";
	}
	
	@GetMapping("/login") 
	public String login() {
		return "login";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@GetMapping("/admin")
	public String admin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user);
		return "admin";
	}
	
	
}
