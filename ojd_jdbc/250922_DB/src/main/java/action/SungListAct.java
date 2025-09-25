package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SjDAO;
import vo.SjVO;

/**
 * Servlet implementation class SungListAct
 */
@WebServlet("/list.do")
public class SungListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//학생목록 가져온다
		List<SjVO> list = SjDAO.getInstance().select();
		
		//list를 바인딩
		request.setAttribute("list", list);

		System.out.println("size : " + list.size());
		
		//포워딩
		RequestDispatcher disp = 
				request.getRequestDispatcher("sj_list.jsp");
		disp.forward(request, response);
	}

}
















