package jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet{
	// mysql 드라이버 로드
    // 서블릿 객체를 실행하면 한번만 실행하도록 처리 (web.xml에 등록)
	@Override    //┌> 패키지가 로드될 때 가장 먼저 호출되는 함수, 초기화 함수
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("mysql 드라이버 로드 성공!");
		} catch (ClassNotFoundException e) {	
			System.out.println("mysql 드라이버 로드 실패!");
			e.printStackTrace();
		}
	}

	
	
	
}
