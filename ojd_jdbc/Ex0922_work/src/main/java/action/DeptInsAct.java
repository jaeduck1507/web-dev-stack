package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptInsAct
 */
@WebServlet("/dept_ins.do")
public class DeptInsAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dept_ins.do?deptno=99&dname=경리부&loc=902호
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		DeptVO vo = new DeptVO();
		vo.setDeptno(deptno);
		vo.setDname(dname);
		vo.setLoc(loc);
		
		DeptDAO.getInstance().insertDept(vo);
		
		//return "redirect:list.do"
		response.sendRedirect("list.do");
		
	}

}









