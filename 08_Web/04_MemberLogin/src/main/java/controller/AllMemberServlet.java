package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDAO;

@WebServlet("/allMember")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao = MemberDAO.getInstance();  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> list = new ArrayList();
		
		try {
			list = dao.searchAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/allMember.jsp").forward(request, response);
	}

}
