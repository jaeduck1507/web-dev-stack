package controller.component;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

public class LoginController implements Controller {
	MemberDAO dao = MemberDAO.getInstance();
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Member user = null;
		
		user = dao.login(id, pwd);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return new ModelAndView("index.jsp",true);
	}

}
