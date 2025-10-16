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
		
		// get으로 받은 파라미터 값 search_txt에 저장
		String search_txt = request.getParameter("search_txt");
		
		// 한글과 같은 문자 인코딩
		String search = URLEncoder.encode(search_txt, "UTF8");
		
		// 네이버에 있는 검색 api를 위한 url(query에 검색할 단어, display에 검색노출결과 개수)
		String urlStr = "https://openapi.naver.com/v1/search/book.json?query=" + search + "&display=20";
		
		// 저장한 urlStr URL객체로 생성
		URL url = new URL(urlStr);
		// HttpURLConnection로 형변환
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		// 연결된 네이버 api에 필요한 정보 전달
		// 발급받은 id
		conn.setRequestProperty("X-Naver-Client-Id", "49uUmSFviEcVkfxqcuQn");
		
		// 발급받은 secret
		conn.setRequestProperty("X-Naver-Client-Secret", "WY1aN2_Izf");
		
		// BufferedReader를 통해 데이터 읽을 객체 선언
		// 데이터는 json구조로 옴
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
		
		String line;
		String resultJson = "";
		// api에서 읽어온 json구조의 내용들을
		// resultJson변수에 저장
		// br.readLine을 통해 다음 라인이 없을때까지 반복해서 resultJson에 저장
		while((line = br.readLine()) != null) {
			resultJson += line;
		}
		
//		System.out.println(resultJson);
		
		// 사용한 객체 연결 종료
		br.close();
		conn.disconnect();
		
		// 검색 결과 전송
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().println("["+ resultJson +"]");
	}

}
