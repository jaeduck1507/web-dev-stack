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

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao = MemberDAO.getInstance();
	
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			list = dao.viewAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
//		String[] sList = new String[list.size()];
//		for(int i = 0; i < list.size(); i++) {
//			Member m = list.get(i);
//			sList[i] = String.format("아이디 : %s, 이름 : %s 비밀번호 : %s 나이 : %d", m.getId(), m.getName(), m.getPwd(), m.getAge());
//		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
