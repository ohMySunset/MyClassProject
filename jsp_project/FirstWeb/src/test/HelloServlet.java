package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
/*서블릿 클래스를 작성할 때 상속해야하는 것*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	/* servlet은 클래스-> 무조건 public클래스로 : 아유는 웹컨테이너가 메서드를 호출할 때 필요함 */
	/* 웹컨테이너 : 서블릿 상속 -> 서블릿 객체 -> 서블릿 초기화 (웹서비스가 가능한 상태로) */
		
	/* web.xml파일에서 정의한 url-pattern 값이 url에 입력되면 아래의 doGEt메서드가 실행 */
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답 : html을 생성해서 반환
		// 응답 관련 객체 : HttpServletResponse response

		// 컨텐트 타입과 케릭터셋 설정
		response.setContentType("text/html; charset=UTF-8");

		//응답처리에 사용할 날짜와 시간 데이터를 가지는 객체
		Date now = new Date();
		
		//html의 응답처리를 위한 스트림 생성
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>now Date</title></head>");
		writer.println("<body>");
		writer.println("<h1>현재시간 : ");
		writer.println(now); // now.toString()
		writer.println("<h1>");
		writer.println("서블릿에서 생성된 응답 코드 입니다.</h1>");
		writer.println("</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}

}
