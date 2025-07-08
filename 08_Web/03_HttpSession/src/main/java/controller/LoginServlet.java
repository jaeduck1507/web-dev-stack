package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DAO 생략 로그인 성공했다 가정하고 
		
		Member member = new Member(id, pwd);
		request.setAttribute("member", member);
		
		//HttpSession
		// 1. 세션을 하나 받는다.
		HttpSession session = request.getSession();
		
		session.setAttribute("user", member);
		// productServlet으로 member 데이터를 가지고 가려고 할 경우
//		request.getRequestDispatcher("product").forward(request, response);
		response.sendRedirect("product");
	}

}
