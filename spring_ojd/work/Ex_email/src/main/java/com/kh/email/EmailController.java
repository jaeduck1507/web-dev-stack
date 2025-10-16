package com.kh.email;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MailSendService;

@Controller
public class EmailController {
	
	// 서비스 객체 호출
	MailSendService mss;
	
	
	public EmailController(MailSendService mss) {
		this.mss = mss;
	}
	
	
	// email_sender.jsp를 페이지 접근을 위한 메서드
	@RequestMapping(value= {"/","start.do"}) // "/", "/start.do" 두개의 url을 통해 email_sender.jsp 호출
	public String start() {
		return "email_sender";
	}
	
	@RequestMapping("/mailCheck.do")
	@ResponseBody // ajax 처리를 위한 어노테이션(리턴값이 body에 넣어짐)
	public String mailCheck(String email) {
		
		// MailSendService의 joinEmail 메서드 수행
		String res = mss.joinEmail(email); // res에 인증번호 값 들어감
		return res;
	}
	
}
