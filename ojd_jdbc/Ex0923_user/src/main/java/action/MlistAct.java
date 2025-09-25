package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MlistAct
 */
@WebServlet("/list.do")
public class MlistAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberVO> list = MemberDAO.getInstance().selectList();
		
		//전체 회원목록을 바인딩
		request.setAttribute("list", list);
		
		//포워딩
		RequestDispatcher disp = 
				request.getRequestDispatcher("member_list.jsp");
		disp.forward(request, response);
		
	}

}










