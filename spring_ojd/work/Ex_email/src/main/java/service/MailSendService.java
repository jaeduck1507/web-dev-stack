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

		makeRandomNuber(); // 난수로 생성한 인증번호 지정
		String setForm = "ojd0708@naver.com"; // 송신자 이메일 저장
		String toMail = email; // 입력받은 이메일을 수신자로 지정
		String title = "회원 가입 인증 이메일 입니다"; // 이메일 제목

		String content = "인증번호는 <b>" + authnumber + "</b> 입니다 그리고 철권 사세요"; // 이메일 내용(인증번호 포함)

		try {
			MimeMessage mail = javaMailSender.createMimeMessage(); // MimeMessage 객체를 javaMailSender.createMimeMessage()를 통해 생성
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8"); // mailHelper의 방식 설정 

			mailHelper.setFrom(setForm); // 송신자 이메일
			mailHelper.setTo(toMail); // 수신자 이메일
			mailHelper.setSubject(title); // 제목
			mailHelper.setText(content, true); // 내용

			javaMailSender.send(mail); // 완성된 이메일 전송

		} catch (Exception e) {
			//System.out.println(e);
			e.printStackTrace();
		}
		
		return String.valueOf(authnumber); // 인증번호 반환(문자열 형태)
		
	}
}
