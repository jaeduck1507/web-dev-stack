package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class LoginController {

	MemberDAO member_dao;

	public LoginController(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}

	@RequestMapping("/login.do" )
	public String loginForm() {
		return "login/login_form";
	}

	@ResponseBody
	@RequestMapping("/check_login.do")
	public String login(MemberVO vo) {

		MemberVO baseVO = member_dao.selectIdCheck(vo.getId());

		String result = "";

		// id가 잘못된 경우
		if (baseVO == null) {
			result = "no_id";
			String resultStr = String.format("[{'res':'%s'}]", result);

			// [{'res':'no_id'}].jsp
			return resultStr;
		}

		PwdBcrypt pbc = new PwdBcrypt();
		boolean isValid = pbc.validPwd(vo.getPwd(), baseVO.getPwd());

		if (!isValid) {
			result = "no_pwd";
			String resultStr = String.format("[{'res':'%s'}]", result);

			return resultStr;
		}
		
		result = "clear";
		String resultStr = String.format("[{'res':'%s'}]", result);
		return resultStr;
	}
}
