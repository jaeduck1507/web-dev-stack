package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class MemberController {
	MemberDAO member_dao;
	
	public MemberController(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	@RequestMapping("list.do")
	public String memberList(Model model) {
		List<MemberVO> list = member_dao.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	@RequestMapping("/member_regi_form.do")
	public String memberRegiForm() {
		return "member/member_regi_form";
	}
	
	@RequestMapping("register.do")
	public String memberRegister(MemberVO vo) {
		
		PwdBcrypt pbc = new PwdBcrypt();
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		vo.setPwd(encodePwd);
		member_dao.memberRegiter(vo);
		return "redirect:/list.do";
	}
	
	@ResponseBody
	@RequestMapping("/member_delete.do")
	public String memberDelete(int idx) {
		int res = member_dao.memberDelete(idx);
		System.out.println(res);
		String result = "no";
		
		if(res == 1) {
			result = "yes";
		}
		
		return result;
	}
}
