package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
                                         //인터페이스 구현
public class DBCPInitListener implements ServletContextListener {

	// 리스너란 특정 이벤트가 발생하기를 ‘귀 기울여’ 기다리다가 실행되는 메서드나 함수,
	// 혹은 그 메서드를 지닌 객체를 가리킨다. 
	// 마우스 클릭, 키보드 입력, 클라이언트로부터의 HTTP 요청, 웹 애플리케이션 시작, 종료 등
	
	// javax.servlet.ServletContextListener : 애플리케이션 컨텍스트 생성/소멸
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
	// contextInitialized()메서드에서는 작업을 수행하고 필요하다면 속성 객체를 만들어
    // application 범위에 속성을 저장해 모든 애플리케이션에서 참고할 수 있도록 한다.
	// Listener 동작이 끝나면 Load-on-startup 으로 설정된 일반 servlet이 실행
		
		ServletContext context = contextEvent.getServletContext();
		
		String driver = context.getInitParameter("jdbcDriver");
		
		try {
			Class.forName(driver);
			System.out.println("톰캣 리스너에서 DB 드라이버 로드 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("톰캣 리스너에서 DB 드라이버 로드 실패!");
			e.printStackTrace();
		}
		
		System.out.println("초기화 완료");
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		
	}


}
