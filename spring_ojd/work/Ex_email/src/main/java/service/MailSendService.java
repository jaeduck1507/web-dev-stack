package service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.*;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSendService {
	private JavaMailSender javaMailSender;
	private int authnumber;

	public MailSendService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	// 난수로 인증번호 생성
	public void makeRandomNuber() {
		Random rnd = new Random();

		// 난수범위 111111 ~ 999999

		int checkNum = rnd.nextInt(999999 - 111111 + 1) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authnumber = checkNum;
	}

	// 이메일을 전달할 양식
	public String joinEmail(String email) {

		makeRandomNuber();
		String setForm = "ojd0708@naver.com";
		String toMail = email;
		String title = "회원 가입 인증 이메일 입니다";

		String content = "인증번호는 <b>" + authnumber + "</b> 입니다 그리고 철권 사세요";

		try {
			MimeMessage mail = javaMailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

			mailHelper.setFrom(setForm);
			mailHelper.setTo(toMail);
			mailHelper.setSubject(title);
			mailHelper.setText(content, true);

			javaMailSender.send(mail);

		} catch (Exception e) {
			//System.out.println(e);
			e.printStackTrace();
		}
		
		return String.valueOf(authnumber);
		
	}
}
