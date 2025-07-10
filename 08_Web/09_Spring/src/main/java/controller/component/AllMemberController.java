package controller.component;

import java.util.ArrayList;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class AllMemberController implements Controller {

	MemberDAO dao = MemberDAO.getInstance();
	
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Member> list = new ArrayList();
		
		
		list = dao.searchAll();
		
		
		request.setAttribute("list", list);
		return new ModelAndView("/views/allMember.jsp");
	}

}
