package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		
		//컨텐트 타입과 캐릭터셋 설정
		response.setContentType("text/html; charset=UTF-8");
		
		//응답처리에 사용할 날짜와 시간데이터
		Date now = new Date();
		
		//HTML의 응답처리를 위한 스트림 생성
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>now Date</title></head>");
		writer.println("<body>");
		writer.println("<h1> 현재시간 </h1>");
		writer.println("<html>");
		writer.println("<html>");
		writer.println("<html>");
		writer.println("<html>");
		
		
		
		
	}


}
