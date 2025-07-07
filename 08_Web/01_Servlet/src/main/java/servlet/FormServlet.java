package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menu = request.getParameterValues("menu");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2> userId : " + userId +"</h2>");
		out.println("<h2> userPwd : " + userPwd +"</h2>");
		out.println("<h2> gender : " + (gender.equals("M") ? "남자" : "여자") +"</h2>");
		if(menu != null) out.println("<h2> menu : " + String.join(", ", menu) +"</h2>");
		// ul li 태크 이용도 해보기
		out.println("</body></html>");
		
		out.close();
	}

}
