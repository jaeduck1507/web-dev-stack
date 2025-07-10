package controller.component;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class RegisterController implements Controller{
	MemberDAO dao = MemberDAO.getInstance();
	/*
	 * 컴포넌트 
	 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
	 * */
	
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(id, name, pwd, age);
		
		dao.register(member);
		return new ModelAndView("index.jsp",true);
	}
}
