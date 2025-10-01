package util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdBcrypt {
	// 암호화
	public String encodingPwd(String pwd) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(pwd);
		
		// 암호화 된 비밀번호 반환
		return encodedPwd;
	}
	// 복호화
	public boolean validPwd(String inputPw,String oriPw) {
		
		boolean isValid = false;
		
		// 					   입력한 비번, 암호화 된 비번
		isValid = BCrypt.checkpw(inputPw, oriPw);
		
		return isValid;
	}
}
