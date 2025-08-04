package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService  {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder bcpe;
	
	public void register(User user) {
//		System.out.println("암호화 전 : " + user.getPwd());
		user.setPwd(bcpe.encode(user.getPwd()));
		
//		System.out.println("암호화 후 : " + user.getPwd());
		if(user.getId().equals("admin")) {
			user.setRole("ROLE_ADMIN");
		} else {
			user.setRole("ROLE_USER");
		}
		userMapper.register(user);
	}
	
	public User login(User vo) {
		User user = userMapper.login(vo.getId());
		
		if(user!=null && bcpe.matches(vo.getPwd(), user.getPwd())) {
			System.out.println("로그인성공");
			return user;
		}
		
		return null;
	}
	

	
}
