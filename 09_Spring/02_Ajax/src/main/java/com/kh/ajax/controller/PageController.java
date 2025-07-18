package com.kh.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
	
	
	
	@GetMapping("/ajax1")
	public String ajax1() {
		return "01_count";
	}
	@GetMapping("/ajax2")
	public String encoding2() {
		return "02_encoding";
	}
	@GetMapping("/ajax3")
	public String register3() {
		return "03_register";
	}
	
	@GetMapping("/ajax4")
	public String register4() {
		return "04_serialize";
	}
	
	@GetMapping("/ajax5")
	public String register5() {
		return "05_formdata";
	}
}
