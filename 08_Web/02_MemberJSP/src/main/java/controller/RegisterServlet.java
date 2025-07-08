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
		
		boolean check = true;
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setAge(age);
		
		try {
			dao.register(member);
		} catch (SQLException e) {
			check =false;
		}
		
		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보내야 할 때
//		request.setAttribute("name", name);
		request.setAttribute("check", check);
		
		
		// 4. 네비게이션 : 결과 페이지 지정
		// 4. 결과 페이지 --> 회원가입 성공할때랑 실패할 때 페이지 구분
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		// 성공
//		if(check) {
//			// response.sendRedirect("result.jsp"); 
//			// 만약 결과 페이지로 서버에서 받은 값 보여주려면
//			// -> requestDispatch forward 방식으로 보내줘야 함
//			request.getRequestDispatcher("result.jsp").forward(request, response);
//		}
//		else response.sendRedirect("fail.jsp");
		// 실패
		
	}
	
	

}
