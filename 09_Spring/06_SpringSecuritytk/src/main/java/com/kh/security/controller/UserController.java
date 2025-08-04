package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.security.config.TokenProvider;
import com.kh.security.model.vo.User;
import com.kh.security.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@PostMapping("/register")
	public String register(User user) {
		userService.register(user);
		return "redirect:/login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public String login(User vo ) {
		User user =  userService.login(vo);
		if(user!=null) {
			// 로그인 성공 -> 서버는 토큰 생성만, 가지고 있는 클라이언트
			String token = tokenProvider.create(user);
			return token;
		}
		return null;
	}
}
