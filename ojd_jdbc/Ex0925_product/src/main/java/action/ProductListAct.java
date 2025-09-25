package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductListAct
 */
@WebServlet("/list.do")
public class ProductListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.do?category=com001
		String category = request.getParameter("category");
		
		// list.do <= null
		// list.do?category=  <= empty
		if(category == null || category.isEmpty()) {
			category = "com001";
		}
		
		// 카테고리별 목록 조회
		List<ProductVO> list = ProductDAO.getInstance().selectCategory(category);
//		System.out.println(list);
		
		// 바인딩
		request.setAttribute("list", list);
		
		//포워딩
		RequestDispatcher disp = request.getRequestDispatcher("product_list.jsp");
		disp.forward(request, response);
		
		
	}

}
