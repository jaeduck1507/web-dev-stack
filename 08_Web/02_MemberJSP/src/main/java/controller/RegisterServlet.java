package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Member member = new Member();   
	MemberDAO dao = MemberDAO.getInstance();
	
    public RegisterServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. (있으면) 폼 값 받아온다.
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")) ;
		
//		System.out.println(name.equals(""));
		
		register(id, pwd, name, age);
		
		// 3. 결과 페이지
		
		response.sendRedirect("result.jsp");
		
		
	}
	
	public void register(String id, String pwd, String name, int age) {
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setAge(age);
		
		try {
			dao.register(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
