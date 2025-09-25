package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class ModifySelAct
 */
@WebServlet("/modify_sel.do")
public class ModifySelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//modify_sel.do?idx=3
		int idx = Integer.parseInt( request.getParameter("idx") );
		
		MemberVO vo = MemberDAO.getInstance().searchIdx( idx );
		
		request.setAttribute("vo", vo);//바인딩
		
		RequestDispatcher disp = 
				request.getRequestDispatcher("modify_form.jsp");
		disp.forward(request, response);
	}

}










