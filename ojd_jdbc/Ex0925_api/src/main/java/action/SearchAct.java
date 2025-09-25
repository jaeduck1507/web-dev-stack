package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAct
 */
@WebServlet("/list.do")
public class SearchAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.do?search_txt = aa
		String search_txt = request.getParameter("search_txt");
		
		String search = URLEncoder.encode(search_txt, "UTF8");
		
		String urlStr = "https://openapi.naver.com/v1/search/book.json?query=" + search + "&display=20";
		
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		// 발급받은 id
		conn.setRequestProperty("X-Naver-Client-Id", "49uUmSFviEcVkfxqcuQn");
		
		// 발급받은 secret
		conn.setRequestProperty("X-Naver-Client-Secret", "WY1aN2_Izf");
		
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
		
		String line;
		String resultJson = "";
		// api에서 읽어온 json구조의 내용들을
		// resultJson변수에 저장
		while((line = br.readLine()) != null) {
			resultJson += line;
		}
		
//		System.out.println(resultJson);
		
		br.close();
		conn.disconnect();
		
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().println("["+ resultJson +"]");
	}

}
